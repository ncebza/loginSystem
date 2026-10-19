/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginsystem_nceba_part1;

/**
 *
 * @author Student
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Message {

    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;
    private String messageStatus;

    private static ArrayList<Message> sentMessages = new ArrayList<>();
    private static ArrayList<Message> storedMessages = new ArrayList<>();
    private static ArrayList<Message> disregardedMessages = new ArrayList<>();
    private static ArrayList<String> usedIDs = new ArrayList<>();

    public Message(int messageNumber, String recipient, String messageText) {
        this.messageID = generateMessageID();
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageHash = createMessageHash();
        this.messageStatus = "";
    }
    public String generateMessageID() {
        Random random = new Random();
        String newID;

        do {
            long number = 1000000000L
                    + (long) (random.nextDouble() * 9000000000L);
            newID = String.valueOf(number);
        } while (usedIDs.contains(newID));

        usedIDs.add(newID);
        return newID;
    }

    public boolean checkMessageID() {
        return messageID != null
                && messageID.matches("[0-9]{10}");
    }

    public boolean checkRecipientCell() {
        if (recipient == null
                || !recipient.matches("\\+[0-9]{10}")) {
            return false;
        }

        return true;
    }

    public boolean checkMessageLength() {
        return messageText != null
                && messageText.length() <= 250;
    }

    public String createMessageHash() {
        if (messageID == null || messageID.length() < 2
                || messageText == null
                || messageText.trim().isEmpty()) {
            return "";
        }

        String[] words = messageText.trim().split("\\s+");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        return (messageID.substring(0, 2) + ":"
                + messageNumber + ":"
                + firstWord + lastWord).toUpperCase();
    }

 public String SentMessage(int choice) {
    switch (choice) {
        case 1:
            messageStatus = "Sent";
            sentMessages.add(this);
            return "Message successfully sent.";

        case 2:
            messageStatus = "Disregarded";
            disregardedMessages.add(this);
            return "Press 0 to delete the message.";

        case 3:
            messageStatus = "Stored";
            storedMessages.add(this);
            storeMessage();
            return "Message successfully stored.";

        default:
            return "Invalid choice.";
    }
}


    public String printMessages() {
    return "Message ID: " + messageID + "\n"
            + "Message Hash: " + messageHash + "\n"
            + "Recipient: " + recipient + "\n"
            + "Message: " + messageText;
}


    public static int returnTotalMessages() {
        return sentMessages.size();
    }

    public void storeMessage() {
        try (FileWriter writer = new FileWriter("messages.json")) {
            writer.write("[\n");

            for (int i = 0; i < storedMessages.size(); i++) {
                Message message = storedMessages.get(i);

                writer.write(" {\n");
                writer.write(" \"messageID\": \""
                        + escapeJSON(message.messageID) + "\",\n");
                writer.write(" \"messageNumber\": "
                        + message.messageNumber + ",\n");
                writer.write(" \"recipient\": \""
                        + escapeJSON(message.recipient) + "\",\n");
                writer.write(" \"messageText\": \""
                        + escapeJSON(message.messageText) + "\",\n");
                writer.write(" \"messageHash\": \""
                        + escapeJSON(message.messageHash) + "\",\n");
                writer.write(" \"messageStatus\": \"Stored\"\n");
                writer.write(" }");

                if (i < storedMessages.size() - 1) {
                    writer.write(",");
                }

                writer.write("\n");
            }

            writer.write("]\n");

        } catch (IOException e) {
            System.out.println("Error storing message.");
        }
    }

    private String escapeJSON(String text) {
        if (text == null) {
            return "";
        }

        return text.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }

    public String getMessageID() {
        return messageID;
    }

    public int getMessageNumber() {
        return messageNumber;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getMessageHash() {
        return messageHash;
    }

    public String getMessageStatus() {
        return messageStatus;
    }

    public static void clearMessagesForTesting() {
        sentMessages.clear();
        storedMessages.clear();
        disregardedMessages.clear();
        usedIDs.clear();
    }
}
