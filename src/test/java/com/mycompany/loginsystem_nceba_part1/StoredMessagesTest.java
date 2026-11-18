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
import java.io.File;
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

        String testData = "["
                + "{"
                + "\"messageID\":\"1111111111\","
                + "\"messageNumber\":1,"
                + "\"recipient\":\"+27838884567\","
                + "\"messageText\":\"Hi there.\","
                + "\"messageHash\":\"11:1:HITHERE\","
                + "\"messageStatus\":\"Stored\""
                + "},"
                + "{"
                + "\"messageID\":\"2222222222\","
                + "\"messageNumber\":2,"
                + "\"recipient\":\"+27838884567\","
                + "\"messageText\":\"This is the longest stored message for testing.\","
                + "\"messageHash\":\"22:2:THISSTORED\","
                + "\"messageStatus\":\"Stored\""
                + "}"
                + "]";

        Files.writeString(filePath, testData);

        StoredMessages.loadStoredMessages();
    }

    @AfterEach
    public void tearDown() throws Exception {

        if (fileExisted) {
            Files.write(filePath, originalFile);
        } else {
            Files.deleteIfExists(filePath);
        }
    }

    private String captureOutput(Runnable action) {

        PrintStream original = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(output));
            action.run();
        } finally {
            System.setOut(original);
        }

        return output.toString();
    }

    @Test
    public void testDisplaySenderAndRecipient() {

        String output = captureOutput(() ->
                new StoredMessages().displaySenderAndRecipient());

        assertTrue(output.contains("Developer"));
        assertTrue(output.contains("+27838884567"));
    }

    @Test
    public void testDisplayLongestMessage() {

        String output = captureOutput(() ->
                new StoredMessages().displayLongestMessage());

        assertTrue(output.contains(
                "This is the longest stored message for testing."));
    }

    @Test
    public void testSearchMessageID() {

        String output = captureOutput(() ->
                new StoredMessages().searchMessageID(
                        new Scanner("2222222222\n")));

        assertTrue(output.contains("+27838884567"));
        assertTrue(output.contains(
                "This is the longest stored message for testing."));
    }

    @Test
    public void testSearchRecipient() {

        String output = captureOutput(() ->
                new StoredMessages().searchRecipient(
                        new Scanner("+27838884567\n")));

        assertTrue(output.contains("Hi there."));
        assertTrue(output.contains(
                "This is the longest stored message for testing."));
    }

    @Test
    public void testDeleteMessage() {

        String output = captureOutput(() ->
                new StoredMessages().deleteMessage(
                        new Scanner("22:2:THISSTORED\n")));

        assertTrue(output.toLowerCase().contains("deleted"));

        String report = captureOutput(() ->
                new StoredMessages().displayReport());

        assertFalse(report.contains(
                "This is the longest stored message for testing."));
    }

    @Test
    public void testDisplayReport() {

        String output = captureOutput(() ->
                new StoredMessages().displayReport());

        assertTrue(output.contains("1111111111"));
        assertTrue(output.contains("2222222222"));
        assertTrue(output.contains("+27838884567"));
        assertTrue(output.contains("Hi there."));
    }    
}
