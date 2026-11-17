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

}
