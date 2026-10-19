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