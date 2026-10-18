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
    private static final Set<String>USED_IDS = new HashSet<>();
    private static  final ArrayList<Message> SENT_MESSAGES = 
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
    public boolean checkMessageID(){
        return messageID != null && messageID.length() <= 10;
    }
    public boolean checkRecipientCell()
    {
        if (recipient == null || !
                recipient.startsWith("+")){
            return false;
        }
        //Allow an international number with 8 to 15 digits 
        //after removing the leading plus sign.
        String digits = recipient.substring(1);
        return digits.matches("[0-9]{8,15}");
    
    }
    public boolean checkMessageLength(){
        return messageText != null && messageText.length() <= 250;
    }
    public String createMessageHash(){
        if (messageID == null || 
                messageText == null
                ||
                messageText.trim().isEmpty()){
            return"";
        }
        String[] words = messageText.trim().split("\\s+");
        String firstWord = words[0].replaceAll("[^a-zA-Z0-9]", "");
        String lastWord = words[words.length - 1].replaceAll("[^a-zA-Z0-9]", "");
        return (messageID.substring(0,2) + ":" +messageNumber + ":" + firstWord + lastWord).toUpperCase();
    }
    public String SentMessage(int choice){
        if (choice == 1){
            SENT_MESSAGES.add(this);
            return "Message succesfully sent.";
        }else if (choice ==2){
            return storeMessage();
        }else if (choice == 3){
            return "Press 0 to delete the message.";
        }
        return "Invalid message option";
    }
    public String printMessages(){
        StringBuilder output = new StringBuilder();
        for (Message message : SENT_MESSAGES){
            output.append("Message ID").append (message.messageID).append("\n");
            output.append("Message: ").append(message.messageText).append("\n\n");
        }
         return output.toString();
    }
     public int returnTotalMessagess() {
        return SENT_MESSAGES.size();
     }
     public String storeMessage() {
        try (FileWriter writer =
                new FileWriter("messages.json", true)) {

            writer.write("{\n");
              writer.write(" \"messageID\": \"" + escapeJSON(messageID) + "\",\n");
              writer.write(" \"messageNumber\": " + messageNumber + ",\n");
              writer.write(" \"recipient\": \"" + escapeJSON(recipient) + "\",\n");
             writer.write(" \"messageText\": \"" + escapeJSON(messageText) + "\",\n");
             writer.write(" \"messageHash\": \"" + escapeJSON(messageHash) + "\"\n");
            writer.write("}\n");

            return "Message successfully stored.";

        } catch (IOException e) {
            return "Message could not be stored: " + e.getMessage();
        }  
     }
      private String escapeJSON(String text) {
        if (text == null) {
            return ""; 
}
          return text.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
            }

    public String getMessageID() {
        return messageID;
    }
      public int getMessageNumber() {
        return messageNumber;
    }
    public String getRecipient() {
        return recipient;
    } 
   public String getMessageText() {
        return messageText;
    } 
   public String getMessageHash() {
        return messageHash;
    }
}