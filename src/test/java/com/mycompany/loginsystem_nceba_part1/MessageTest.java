/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginsystem_nceba_part1;

/**
 *
 * @author Student
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {
    
   @Test
    public void testCheckMessageID() {
        Message message = new Message(
                1, "+27812345678", "Hello there");

        assertTrue(message.checkMessageID());
        assertEquals(10, message.getMessageID().length());
    } 
     @Test
    public void testCheckRecipientCellSuccess() {
        Message message = new Message(
                1, "+27812345678", "Hello there");

        assertTrue(message.checkRecipientCell());
    }

    @Test
    public void testCheckRecipientCellFailure() {
        Message message = new Message(
                1, "27812345678", "Hello there");

        assertFalse(message.checkRecipientCell());
    }
   @Test
    public void testCheckMessageLengthSuccess() {
        Message message = new Message(
                1, "+27812345678", "Hello there");

        assertTrue(message.checkMessageLength());
    } 
     @Test
    public void testCheckMessageLengthFailure() {
        String longMessage = "A".repeat(251);

        Message message = new Message(
                1, "+27812345678", longMessage);

        assertFalse(message.checkMessageLength());
    } 
   @Test
    public void testCreateMessageHash() {
        Message message = new Message(
                1, "+27812345678", "Hi there");

        String hash = message.createMessageHash();

        assertTrue(hash.matches("[0-9]{2}:1:HITHERE"));
    }
 
}
