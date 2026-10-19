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
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @BeforeEach
    public void setUp() {
        Message.clearMessagesForTesting();
    }

    @Test
    public void testMessageID() {
        Message message = new Message(
                1, "+27812345678", "Hello world");

        assertTrue(message.checkMessageID());
        assertEquals(10, message.getMessageID().length());
    }

    @Test
    public void testRecipientCellValid() {
        Message message = new Message(
                1, "+27812345678", "Hello");

        assertTrue(message.checkRecipientCell());
    }

    @Test
    public void testRecipientCellInvalid() {
        Message message = new Message(
                1, "0812345678", "Hello");

        assertFalse(message.checkRecipientCell());
    }
@Test
    public void testMessageLengthValid() {
        Message message = new Message(
                1, "+27812345678", "Hello world");

        assertTrue(message.checkMessageLength());
    }

    @Test
    public void testMessageLengthInvalid() {
        String longText = "a".repeat(251);

        Message message = new Message(
                1, "+27812345678", longText);

        assertFalse(message.checkMessageLength());
    }

    @Test
    public void testMessageHashCreated() {
        Message message = new Message(
                1, "+27812345678", "Hello world");

        String hash = message.getMessageHash();

        assertFalse(hash.isEmpty());
        assertTrue(hash.startsWith(
                message.getMessageID().substring(0, 2)));
        assertTrue(hash.contains(":1:"));
        assertTrue(hash.endsWith("HELLOWORLD"));
    }

    @Test
    public void testSendMessage() {
        Message message = new Message(
                1, "+27812345678", "Hello world");

        String result = message.SentMessage(1);

        assertEquals("Message successfully sent.", result);
        assertEquals("Sent", message.getMessageStatus());
        assertEquals(1, Message.returnTotalMessagess());
    }

    @Test
    public void testStoreMessage() {
        Message message = new Message(
                1, "+27812345678", "Hello world");

        String result = message.SentMessage(2);

        assertEquals("Message successfully stored.", result);
        assertEquals("Stored", message.getMessageStatus());
        assertEquals(0, Message.returnTotalMessagess());
    }

    @Test
    public void testDisregardMessage() {
        Message message = new Message(
                1, "+27812345678", "Hello world");

        String result = message.SentMessage(3);

        assertEquals("Press 0 to delete the message.", result);
        assertEquals("Disregarded", message.getMessageStatus());
        assertEquals(0, Message.returnTotalMessagess());
    }

    @Test
    public void testInvalidChoice() {
        Message message = new Message(
                1, "+27812345678", "Hello world");

        assertEquals("Invalid choice.", message.SentMessage(5));
    }
}
