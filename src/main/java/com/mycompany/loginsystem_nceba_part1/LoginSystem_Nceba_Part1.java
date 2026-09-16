/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginsystem_nceba_part1;

/**
 *
 * @author Student
 */
import java.util.Scanner;
public class LoginSystem_Nceba_Part1 {

    public static void main(String[] args) {                                                                                                                                                                                                                                                                                                                                                             
        //Declarations
         Register register = new Register();
         LoginClass login = new LoginClass();
         String name;
         String surname;
         String username;
         String password;
         String regUsername = "";
         String regPassword = "";
         String regPhone = "";
         
         
         //Prompt user
         Scanner input = new
      Scanner(System.in);
        System.out.print("Enter Name");
        name = input.nextLine();
        System.out.println("Enter Surname");
        surname = input.nextLine();
        //Username
        while (true){
           System.out.println("Enter username: ");
           username = input.nextLine();
        
        if(register.checkUserName(username)){   
         System.out.println("username successfully captured");
         regUsername = username;
         break;
        } else {
           System.out.println("username is not correcttly formatted, "
                   + "please ensure that your username contains an underscore"
                   + " and is no mmore than five characters long");
           System.out.println("");
                   } 
    }
      //password
      while(true){
          System.out.print("Enter Password: ");
       password = input.nextLine();
       if(register.checkPasswordComplexity(password)){
           System.out.println("Password successful captured.");
           regPassword = password;
           break;
       }
       else{
           System.out.println("Password is not correctly formatted, please ensure that the password "
                   + "contains at least eight characters, a capital letter, a number, and a special character.");
       }
       }
      //cellphone
      while(true){
          System.out.println("Enter cellphone Number: ");
          String phone = input.nextLine();
          if(register.checkCellPhoneNumber(phone)){
           System.out.println("Cell phone number successfully added."); 
           regPhone = phone;
           break;
          }else{
           System.out.println("Cell Phone number incorrectly formatted or does not contain international code.");   
          }
          }
      
                     
      //Login section from here
      System.out.println("\n==== LOGIN ===" );
      System.out.print("Enter Username: ");
      String loginUser = input.nextLine();
      System.out.print("Enter Passowrd: ");
      String loginPass  = input.nextLine();
      String message = login.returnLoginStatus(loginUser, loginPass, regUsername, regPassword, name, surname);
      System.out.println(message);
      input.close();
      }
    }

