/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginsystem_nceba_part1;

/**
 *
 * @author Student
 */
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class StoredMessages {
 // Arrays required for Part 3
    private static Message[] sentMessages = new Message[100];
    private static Message[] disregardedMessages = new Message[100];
  
private static String[] messageIDs = new String[100];
    private static String[] messageHashes = new String[100];

// Arrays for messages read from the JSON file
    private static String[] storedMessageIDs = new String[100];
    private static String[] storedRecipients = new String[100];
    private static String[] storedMessageTexts = new String[100];
    private static String[] storedMessageHashes = new String[100];
    private static String[] storedSenders = new String[100];
    private static int[] storedMessageNumbers = new int[100];
  
 private static int sentCount = 0;
    private static int disregardedCount = 0;
    private static int messageIDCount = 0;
    private static int messageHashCount = 0;
    private static int storedCount = 0;
 
private static final String FILE_NAME = "messages.json";

  // Main menu for stored messages
    public void displayStoredMessagesMenu(Scanner input) {

        loadStoredMessages();

         String choice;

        do {
            System.out.println("\n===== STORED MESSAGES =====");
            System.out.println("1. Display sender and recipient");
            System.out.println("2. Display longest stored message");
            System.out.println("3. Search message using Message ID");
            System.out.println("4. Search messages using recipient");
            System.out.println("5. Delete message using Message Hash");
            System.out.println("6. Display stored messages report");
            System.out.println("0. Return to main menu");
            System.out.print("Enter your choice: ");

             choice = input.nextLine();

            switch (choice) {

                case "1":
                    displaySenderAndRecipient();
                    break;

                case "2":
                    displayLongestMessage();
                    break;

                case "3":
                    searchMessageID(input);
                    break;

                case "4":
                    searchRecipient(input);
                    break;
                    
                    case "5":
                    deleteMessage(input);
                    break;

                case "6":
                    displayReport();
                    break;

                case "0":
                    System.out.println("Returning to main menu...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (!choice.equals("0"));
    }
// Read stored messages from the JSON file into arrays
    public static void loadStoredMessages() {

        storedCount = 0;
messageIDCount = 0;
messageHashCount = 0;

// IDs and hashes for sent messages
for (int i = 0; i < sentCount; i++) {
    addMessageID(sentMessages[i].getMessageID());
    addMessageHash(sentMessages[i].getMessageHash());
}

//IDs and hashes for disregarded messages
for (int i = 0; i < disregardedCount; i++) {
    addMessageID(disregardedMessages[i].getMessageID());
    addMessageHash(disregardedMessages[i].getMessageHash());
}


        try (FileReader reader = new FileReader(FILE_NAME)) {

            JsonArray messages = JsonParser.parseReader(reader).getAsJsonArray();

            for (int i = 0; i < messages.size() && storedCount < 100; i++) {

                JsonObject message = messages.get(i).getAsJsonObject();
                storedMessageIDs[storedCount] =
                        getStringValue(message, "messageID");

                storedRecipients[storedCount] =
                        getStringValue(message, "recipient");

                storedMessageTexts[storedCount] =
                        getStringValue(message, "messageText");

                storedMessageHashes[storedCount] =
                        getStringValue(message, "messageHash");
 storedSenders[storedCount] =
                        getStringValue(message, "sender");

                if (storedSenders[storedCount].isEmpty()) {
                    storedSenders[storedCount] = "Developer";
                }

                if (message.has("messageNumber")) {
                    storedMessageNumbers[storedCount] =
                            message.get("messageNumber").getAsInt();
                } else {
                    storedMessageNumbers[storedCount] = 0;
                }
  addMessageID(storedMessageIDs[storedCount]);
                addMessageHash(storedMessageHashes[storedCount]);

                storedCount++;
            }

        } catch (IOException e) {
            System.out.println("Could not read the messages.json file.");
        } catch (Exception e) {
            System.out.println("There was a problem reading the stored messages.");
        }
    }
  // Get a value from the JSON file safely
    private static String getStringValue(JsonObject message, String field) {

        if (message.has(field) && !message.get(field).isJsonNull()) {
            return message.get(field).getAsString();
        }

        return "";
    }  
  // Add a message ID to the Message ID array
    private static void addMessageID(String messageID) {

        if (messageID == null || messageID.isEmpty()) {
            return;
        }

        for (int i = 0; i < messageIDCount; i++) {
            if (messageIDs[i].equals(messageID)) {
                return;
            }
        }
      if (messageIDCount < messageIDs.length) {
            messageIDs[messageIDCount] = messageID;
            messageIDCount++;
        }
    } 
      // Add a message hash to the Message Hash array
    private static void addMessageHash(String messageHash) {

        if (messageHash == null || messageHash.isEmpty()) {
            return;
        }
         for (int i = 0; i < messageHashCount; i++) {
            if (messageHashes[i].equals(messageHash)) {
                return;
            }
        }
     if (messageHashCount < messageHashes.length) {
            messageHashes[messageHashCount] = messageHash;
            messageHashCount++;
        }
    }

    // These methods will connect Message.java to the Part 3 arrays
    public static void addSentMessage(Message message) {

        if (sentCount < sentMessages.length) {
            sentMessages[sentCount] = message;
            sentCount++;
        }
 addMessageID(message.getMessageID());
        addMessageHash(message.getMessageHash());
    }
   public static void addDisregardedMessage(Message message) {

        if (disregardedCount < disregardedMessages.length) {
            disregardedMessages[disregardedCount] = message;
            disregardedCount++;
        }

        addMessageID(message.getMessageID());
        addMessageHash(message.getMessageHash());
    }
     public static void addStoredMessage(Message message) {

        if (storedCount < 100) {

            storedMessageIDs[storedCount] = message.getMessageID();
            storedRecipients[storedCount] = message.getRecipient();
            storedMessageTexts[storedCount] = message.getMessageText();
            storedMessageHashes[storedCount] = message.getMessageHash();
            storedSenders[storedCount] = "Developer";
            storedMessageNumbers[storedCount] = message.getMessageNumber();

            storedCount++;

            addMessageID(message.getMessageID());
            addMessageHash(message.getMessageHash());

            saveStoredMessages();
        }
    }
    // Option 1: Display sender and recipient
    public void displaySenderAndRecipient() {

        if (storedCount == 0) {
            System.out.println("There are no stored messages.");
            return;
        }

        System.out.println("\n===== SENDERS AND RECIPIENTS =====");

        for (int i = 0; i < storedCount; i++) {

            System.out.println("Sender: " + storedSenders[i]);
            System.out.println("Recipient: " + storedRecipients[i]);
            System.out.println("----------------------------");
        }
    }
    // Option 2: Display the longest stored message
    public void displayLongestMessage() {

        if (storedCount == 0) {
            System.out.println("There are no stored messages.");
            return;
        }

        int longestIndex = 0;

        for (int i = 1; i < storedCount; i++) {

            if (storedMessageTexts[i].length()
                    > storedMessageTexts[longestIndex].length()) {

                longestIndex = i;
            }
        }
 System.out.println("\n===== LONGEST STORED MESSAGE =====");
        System.out.println(storedMessageTexts[longestIndex]);
    }
 // Option 3: Search using Message ID
    public void searchMessageID(Scanner input) {

        System.out.print("Enter the Message ID: ");
        String searchID = input.nextLine();

        boolean found = false;

        for (int i = 0; i < storedCount; i++) {

            if (storedMessageIDs[i].equals(searchID)) {

                System.out.println("\nMessage found!");
                System.out.println("Recipient: " + storedRecipients[i]);
                System.out.println("Message: " + storedMessageTexts[i]);

                found = true;
                break;
            }
        }
     if (!found) {
            System.out.println("Message ID not found.");
        }
    }
  // Option 4: Search messages using recipient
    public void searchRecipient(Scanner input) {

        System.out.print("Enter the recipient number: ");
        String searchNumber = input.nextLine();

        boolean found = false;

        System.out.println("\n===== MESSAGES FOR RECIPIENT =====");

        for (int i = 0; i < storedCount; i++) {

            if (storedRecipients[i].equals(searchNumber)) {

                System.out.println("Message: " + storedMessageTexts[i]);
                found = true;
            }
        }
          if (!found) {
            System.out.println("No messages found for this recipient.");
        }
    }
     // Option 5: Delete a message using its Message Hash
    public void deleteMessage(Scanner input) {

        System.out.print("Enter the Message Hash: ");
        String searchHash = input.nextLine();

        boolean found = false;

        for (int i = 0; i < storedCount; i++) {

            if (storedMessageHashes[i].equals(searchHash)) {

                String deletedMessage = storedMessageTexts[i];

                for (int j = i; j < storedCount - 1; j++) {

                    storedMessageIDs[j] = storedMessageIDs[j + 1];
                    storedRecipients[j] = storedRecipients[j + 1];
                    storedMessageTexts[j] = storedMessageTexts[j + 1];
                    storedMessageHashes[j] = storedMessageHashes[j + 1];
                    storedSenders[j] = storedSenders[j + 1];
                    storedMessageNumbers[j] = storedMessageNumbers[j + 1];
                }
  storedCount--;

                saveStoredMessages();

                System.out.println("Message: \"" + deletedMessage
                        + "\" successfully deleted.");

                found = true;
                break;
            }
        }
           if (!found) {
            System.out.println("Message Hash not found.");
        }
    }

    // Option 6: Display a full report
    public void displayReport() {

        if (storedCount == 0) {
            System.out.println("There are no stored messages.");
            return;
        }
   System.out.println("\n========== STORED MESSAGES REPORT ==========");

        for (int i = 0; i < storedCount; i++) {

            System.out.println("\nMessage Number: " + storedMessageNumbers[i]);
            System.out.println("Message ID: " + storedMessageIDs[i]);
            System.out.println("Message Hash: " + storedMessageHashes[i]);
            System.out.println("Sender: " + storedSenders[i]);
            System.out.println("Recipient: " + storedRecipients[i]);
            System.out.println("Message: " + storedMessageTexts[i]);
            System.out.println("Status: Stored");
            System.out.println("--------------------------------------------");
        }
    }
     // Save the stored message arrays back into the JSON file
    private static void saveStoredMessages() {

        JsonArray messages = new JsonArray();

        for (int i = 0; i < storedCount; i++) {

            JsonObject message = new JsonObject();

            message.addProperty("messageID", storedMessageIDs[i]);
            message.addProperty("messageNumber", storedMessageNumbers[i]);
            message.addProperty("recipient", storedRecipients[i]);
            message.addProperty("messageText", storedMessageTexts[i]);
            message.addProperty("messageHash", storedMessageHashes[i]);
            message.addProperty("sender", storedSenders[i]);
            message.addProperty("messageStatus", "Stored");

            messages.add(message);
        }
         Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(FILE_NAME)) {

            gson.toJson(messages, writer);

        } catch (IOException e) {
            System.out.println("Error saving stored messages.");
        }
    }
}    

