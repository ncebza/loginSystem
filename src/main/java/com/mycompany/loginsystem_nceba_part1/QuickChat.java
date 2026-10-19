/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginsystem_nceba_part1;

/**
 *
 * @author Student
 */
import java.util.Scanner;

public class QuickChat {

    private Scanner input;
    private int nextMessageNumber = 1;
    private int messagesProcessed = 0;
    private int numberOfMessages;

    public QuickChat(Scanner input) {
        this.input = input;
    }
