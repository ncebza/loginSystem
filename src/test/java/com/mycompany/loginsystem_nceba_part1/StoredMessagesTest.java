/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginsystem_nceba_part1;

/**
 *
 * @author Student
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class StoredMessagesTest {

    private Path filePath = Path.of("messages.json");
    private byte[] originalFile;
    private boolean fileExisted;

    @BeforeEach
    public void setUp() throws Exception {

        fileExisted = Files.exists(filePath);

        if (fileExisted) {
            originalFile = Files.readAllBytes(filePath);
        }

        // The two prescribed stored messages: #2 and #5
        String testData = "["
                + "{"
                + "\"messageID\":\"2222222222\","
                + "\"messageNumber\":2,"
                + "\"recipient\":\"+27838884567\","
                + "\"messageText\":\"Where are you? You are late! I have asked you to be on time.\","
                + "\"messageHash\":\"22:2:WHERETIME.\","
                + "\"sender\":\"Developer\","
                + "\"messageStatus\":\"Stored\""
                + "},"
                + "{"
                + "\"messageID\":\"5555555555\","
                + "\"messageNumber\":5,"
                + "\"recipient\":\"+27838884567\","
                + "\"messageText\":\"Ok, I am leaving without you.\","
                + "\"messageHash\":\"55:5:OK,YOU.\","
                + "\"sender\":\"Developer\","
                + "\"messageStatus\":\"Stored\""
                + "}"
                + "]";

        Files.writeString(filePath, testData);

        StoredMessages.loadStoredMessages();
    }

    @AfterEach
    public void tearDown() throws Exception {

        // Restore the original JSON file
        if (fileExisted) {
            Files.write(filePath, originalFile);
        } else {
            Files.deleteIfExists(filePath);
        }
    }

    // Capture output displayed by methods
    private String captureOutput(Runnable action) {

        PrintStream original = System.out;
        ByteArrayOutputStream output =
                new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(output));
            action.run();
        } finally {
            System.setOut(original);
        }

        return output.toString();
    }

    // Test 1: Display sender and recipient
    @Test
    public void testDisplaySenderAndRecipient() {

        String output = captureOutput(() ->
                new StoredMessages().displaySenderAndRecipient());

        assertTrue(output.contains("Developer"));
        assertTrue(output.contains("+27838884567"));
    }

    // Test 2: Display the longest stored message
    @Test
    public void testDisplayLongestMessage() {

        String output = captureOutput(() ->
                new StoredMessages().displayLongestMessage());

        assertTrue(output.contains(
                "Where are you? You are late! I have asked you to be on time."));
    }

    // Test 3: Search using a stored message ID
    @Test
    public void testSearchMessageID() {

        String output = captureOutput(() ->
                new StoredMessages().searchMessageID(
                        new Scanner("2222222222\n")));

        assertTrue(output.contains("+27838884567"));

        assertTrue(output.contains(
                "Where are you? You are late! I have asked you to be on time."));
    }

    // Test 4: Search messages using recipient
    @Test
    public void testSearchRecipient() {

        String output = captureOutput(() ->
                new StoredMessages().searchRecipient(
                        new Scanner("+27838884567\n")));

        assertTrue(output.contains(
                "Where are you? You are late! I have asked you to be on time."));

        assertTrue(output.contains(
                "Ok, I am leaving without you."));
    }

    // Test 5: Delete a stored message using its hash
    @Test
    public void testDeleteMessage() {

        String output = captureOutput(() ->
                new StoredMessages().deleteMessage(
                        new Scanner("22:2:WHERETIME.\n")));

        assertTrue(output.contains(
                "Message: \"Where are you? You are late! I have asked you to be on time.\" successfully deleted."));

        String report = captureOutput(() ->
                new StoredMessages().displayReport());

        assertFalse(report.contains(
                "Where are you? You are late! I have asked you to be on time."));

        assertTrue(report.contains(
                "Ok, I am leaving without you."));
    }

    // Test 6: Display the full stored messages report
    @Test
    public void testDisplayReport() {

        String output = captureOutput(() ->
                new StoredMessages().displayReport());

        assertTrue(output.contains("2222222222"));
        assertTrue(output.contains("5555555555"));

        assertTrue(output.contains("22:2:WHERETIME."));
        assertTrue(output.contains("55:5:OK,YOU."));

        assertTrue(output.contains("+27838884567"));

        assertTrue(output.contains(
                "Where are you? You are late! I have asked you to be on time."));

        assertTrue(output.contains(
                "Ok, I am leaving without you."));
    }

    // Test 7: Search for prescribed sent message #4
    @Test
    public void testSearchMessageFourID() {

        Message message4 = new Message(
                4,
                "+27838884567",
                "It is dinner time !",
                "0838884567");

        message4.SentMessage(1);

        String output = captureOutput(() ->
                new StoredMessages().searchMessageID(
                        new Scanner("0838884567\n")));

        assertTrue(output.contains("It is dinner time !"));
    }
}

