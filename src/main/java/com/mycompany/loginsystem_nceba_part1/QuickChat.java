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

    private Scanner input;
    private int nextMessageNumber = 1;
    private int messagesProcessed = 0;
    private int numberOfMessages;

    public QuickChat(Scanner input) {
        this.input = input;
    }
  public void runChat() {
        System.out.println("Welcome to QuickChat.");

        numberOfMessages = readPositiveNumber();
        boolean running = true;

        while (running) {
            System.out.println("\nQuickChat Menu");
            System.out.println("1. Send Messages");
            System.out.println("2. Show recently sent messages");
            System.out.println("3. Quit");

            System.out.print("Choose an option: ");
            String option = input.nextLine();

            switch (option) {
                case "1":
                    if (messagesProcessed < numberOfMessages) {
                        sendMessages();
                    } else {
                        System.out.println(
                                "You have reached your selected message limit.");
                    }
                    break;

                case "2":
                    System.out.println("Coming Soon.");
                    break;

                case "3":
                    System.out.println("Total messages sent: "
                            + Message.returnTotalMessagess());
                    System.out.println("Thank you for using QuickChat.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
  private int readPositiveNumber() {
        while (true) {
            System.out.print("How many messages would you like to send? ");
            String answer = input.nextLine();

            try {
                int number = Integer.parseInt(answer);

                if (number > 0) {
                    return number;
                }

                System.out.println("Enter a number greater than zero.");

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }
     private void sendMessages() {
        while (messagesProcessed < numberOfMessages) {
            String recipient;

            while (true) {
                System.out.print(
                        "Enter recipient number with country code: ");
                recipient = input.nextLine();

                if (recipient.matches("^\\+27[0-9]{9}$")) {
    break;
}
                System.out.println("Invalid recipient number. Try again.");
            }

            String messageText;

            while (true) {
                System.out.print(
                        "Enter your message (maximum 250 characters): ");
                messageText = input.nextLine();

                if (messageText.length() <= 250) {
                    break;
                }

                System.out.println("Your message is too long.");
            }

            Message message = new Message(
                    nextMessageNumber, recipient, messageText);

            System.out.println("Message ID: " + message.getMessageID());
            System.out.println("Message Hash: " + message.getMessageHash());

            System.out.println("1. Send message");
            System.out.println("2. Store message");
            System.out.println("3. Disregard message");
            System.out.print("Choose an option: ");

            String answer = input.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(answer);
            } catch (NumberFormatException e) {
                choice = 0;
            }
         String result = message.SentMessage(choice);
            System.out.println(result);

            if (choice >= 1 && choice <= 3) {
                messagesProcessed++;
                nextMessageNumber++;
            }

            if (message.getMessageStatus().equals("Sent")) {
                message.printMessages();
            }

            if (messagesProcessed >= numberOfMessages) {
                System.out.println(
                        "You have processed all your selected messages.");
            }

            if (choice < 1 || choice > 3) {
                System.out.println("Please enter 1, 2, or 3.");
            }

            if (messagesProcessed >= numberOfMessages
                    || choice < 1 || choice > 3) {
                break;
            }
  
        }
    }
}
   