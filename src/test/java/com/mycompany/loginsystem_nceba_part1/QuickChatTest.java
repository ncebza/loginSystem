/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginsystem_nceba_part1;

/**
 *
 * @author Student
 */
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuickChatTest {

    @Test
    public void testQuickChatCanQuit() {
        String simulatedInput = "1\n3\n";

        Scanner input = new Scanner(
                new StringReader(simulatedInput));

        QuickChat quickChat = new QuickChat(input);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOutput = System.out;

        try {
            System.setOut(new PrintStream(output));
            quickChat.runChat();
        } finally {
            System.setOut(originalOutput);
            input.close();
        }

        assertTrue(output.toString().contains("Welcome to QuickChat."));
        assertTrue(output.toString().contains(
                "Thank you for using QuickChat."));
    }
}

