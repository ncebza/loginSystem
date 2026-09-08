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
         String name;{
         String surname;
         String username;
         String password;
         String email;
         
         //Prompt user
         Scanner input = new
      Scanner(System.in);
        System.out.print("Enter Name");
        name = input.nextLine();
        System.out.println("Enter Surname");
        surname = input.nextLine();
     
        while (true){
           System.out.println("Enter your username: ");
           username = input.nextLine();
        
        if(checkUserName(username)){   
         System.out.println("username successfully captured");
         break;
        } else {
           System.out.println("username is not correctlty formated");
           System.out.println("");
                   } 
    }
    }
        public static boolean
                checkUserName(String username) {
                   return (username.contains("")&&
                   username.length() <= 5);
                }
       //surname
System.out.println("Enter Surname: ");
surname = input.nextLine(); 

//Aak for email adress
while (true){
       System.out.println("Enter yout Email Adress");
       email = input.nextLine();
       if  (checkEmail(email)){
       System.out.println("Email successufully captured");
       break;
       }else {
       System.out.println("Email not correctly formated");
      }
    }
}
public static boolean
checkEmail(String email){
        return email.contains("@")&&
                email.contains(".");}
//Ask for passoword
while (true){
System.out.print("Enter your password: ");
password = input.nextLine();

if (checkPassword(password)) {
System.out.println("Passoword successfully captured");
break;
        }else{
System.out.println("Password is not correctly formated");
System.out.println("Password must: ");
System.out.println("-Be atleast 8 characters long");
System.out.println("Contain at least one captial lettr");
System.out.println("Contain at least one number");
System.out.println("Contain atleast one specail character");
}
}
