/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginsystem_nceba_part1;

/**
 *
 * @author Student
 */
public class Register {
    //To check if the username has an underscore and to see if it is no longer than 5 characters
    public boolean checkUserName(String username){
        return
    username.contains("_") && username.length() <=5;
  
    }
    //This is to see if the passwords meets the rules
    public boolean checkPasswordComplexity(String password) {
        //If the password is shorter than 8 it fails immeiately
        if (password.length() <8){
    return false;        
        }
        //This is to check if we find each required type of character
        boolean hasCapital = false;
        boolean hasSpecial = false;
        boolean hasNumber = false;
        //The loop and if statement will go through each character in the password one by one
      for(int i = 0; i <password.length();i++){
          char c = password.charAt(i);
          if(Character.isUpperCase(c)){
              hasCapital = true;
          }
          if(Character.isDigit(c)){
              hasNumber = true;
          }
          if(!Character.isLetterOrDigit(c)){
              hasSpecial = true;
          }
      }
      //The password is vaild if all the three types of characters are found
      return hasCapital
              && hasNumber
              && hasSpecial;
        
      
    }
    //To make sure that the cell phone number starts with code +27 and 9 extra phone numbers
    public boolean checkCellPhoneNumber(String phoneNum){
        String regex = "^\\+27[0-9]{9}$";
        return
    phoneNum.matches(regex);
    }
    
}
