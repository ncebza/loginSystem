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
}

                     
