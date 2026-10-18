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
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuickChatTest {
     @Test
    public void testShowRecentlySentMessages() {
        String simulatedInput =
                "1\n2\n3\n";

        Scanner scanner = new Scanner(simulatedInput);
        QuickChat quickChat = new QuickChat(scanner);

        ByteArrayOutputStream output =
                new ByteArrayOutputStream();

        PrintStream originalOutput = System.out;

        try {
            System.setOut(new PrintStream(output));
            quickChat.runChat();
        } finally {
            System.setOut(originalOutput);
        } 
      assertTrue(output.toString().contains("Coming Soon."));
    }
}
