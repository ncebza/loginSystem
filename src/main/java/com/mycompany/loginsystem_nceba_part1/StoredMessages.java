/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginsystem_nceba_part1;

/**
 *
 * @author Student
 */
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class StoredMessages {
 // Arrays required for Part 3
    private static Message[] sentMessages = new Message[100];
    private static Message[] disregardedMessages = new Message[100];
  
private static String[] messageIDs = new String[100];
    private static String[] messageHashes = new String[100];

// Arrays for messages read from the JSON file
    private static String[] storedMessageIDs = new String[100];
    private static String[] storedRecipients = new String[100];
    private static String[] storedMessageTexts = new String[100];
    private static String[] storedMessageHashes = new String[100];
    private static String[] storedSenders = new String[100];
    private static int[] storedMessageNumbers = new int[100];
  
 private static int sentCount = 0;
    private static int disregardedCount = 0;
    private static int messageIDCount = 0;
    private static int messageHashCount = 0;
    private static int storedCount = 0;
   
}
