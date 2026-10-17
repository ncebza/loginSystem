/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginsystem_nceba_part1;

/**
 *
 * @author Student
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Message {
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash; 
    
    private static final Random RANDOM = new Random();
    private Static final Set<String>USED_IDS = new HashSet<>();
    private Static  final ArrayList<Message> SENT_MESSAGES = 
            new ArrayList<>();
    public Message(int messageNumber, String recipient, String messageText){
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
    }
    private String generateMessageID()
    {
        String id;
        
        do{
            long number = 1_000_000_000
                    + (long)
                    (RANDOM.nextDouble()*9_000_000_000L);
            id = String.valueOf(number);
      
        }
        while (USED_IDS.contains(id));
        USED_IDS.add(id);
      return id;
    }
    
}
