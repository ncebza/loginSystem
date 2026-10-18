/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginsystem_nceba_part1;

/**
 *
 * @author Student
 */
import java.util.Scanner;
public class QuickChat {
       private final Scanner input;

    public QuickChat(Scanner input) {
        this.input = input;
    }
    public void runChat() {
        System.out.println("\nWelcome to QuickChat.");

        int numberOfMessages = readPositiveNumber(
                "How many messages would you like to send? ");

        int messagesCreated = 0;
        int nextMessageNumber = 0;

        while (true) {
            System.out.println("\n1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Choose an option: ");

            String option = input.nextLine();

            if (option.equals("1")) {
                if (messagesCreated >= numberOfMessages) {
                    System.out.println("You have reached your message limit.");
                    continue;
                }
                System.out.print("Enter recipient number with international code: ");
                String recipient = input.nextLine();

                Message message = new Message(
                        nextMessageNumber, recipient, "");

                if (!message.checkRecipientCell()) {
                    System.out.println("Invalid recipient number.");
                    continue;
                }
                  System.out.print("Enter your message (maximum 250 characters): ");
                String messageText = input.nextLine();

                message = new Message(
                        nextMessageNumber, recipient, messageText);

                if (!message.checkMessageID()) {
                    System.out.println("Invalid message ID.");
                    continue;
                }
                 if (!message.checkMessageLength()) {
                    System.out.println("Please enter a message of 250 characters or less.");
                    continue;
                }
              System.out.println("\nMessage Hash: "
                        + message.createMessageHash());

                System.out.println("\nChoose what to do with your message:");
                System.out.println("1) Send message");
                System.out.println("2) Store message");
                System.out.println("3) Disregard message");
                System.out.print("Choose an option: ");

                String messageChoice = input.nextLine();
                int choice;

                try {
                    choice = Integer.parseInt(messageChoice);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid option.");
                    continue;
                }

                if (choice < 1 || choice > 3) {
                    System.out.println("Invalid option.");
                    continue;
                } 
              
                System.out.println(message.SentMessage(choice));

                if (choice == 1) {
                    System.out.println("\nMessage details:");
                    System.out.println("Message ID: " + message.getMessageID());
                    System.out.println("Message Hash: " + message.getMessageHash());
                    System.out.println("Recipient: " + message.getRecipient());
                    System.out.println("Message: " + message.getMessageText());
                }
    messagesCreated++;
                nextMessageNumber++;

            } else if (option.equals("2")) {
                System.out.println("Coming Soon.");

            } else if (option.equals("3")) {
                System.out.println("Total messages sent: "
                        + new Message(0, "+27786074306", "temporary")
                                .returnTotalMessagess());
                System.out.println("Goodbye.");
                break;

            } else {
                System.out.println("Invalid option. Please choose 1, 2 or 3.");
            }
        }
    }

    private int readPositiveNumber(String prompt) {
        while (true) {
            System.out.print(prompt);
            String answer = input.nextLine();

            try {
                int number = Integer.parseInt(answer);

                if (number > 0) {
                    return number;
                }
}

                     
