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
