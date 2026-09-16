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
    public boolean checkUserName(String username){
        return
    username.contains("_") && username.length() <=5;
  
    }
    public boolean checkPasswordComplexity(String password) {
        if (password.length() <8){
    return false;        
        }
        boolean hasCapital = false;
        boolean hasSpecial = false;
        boolean hasNumber = false;
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
      return hasCapital
              && hasNumber
              && hasSpecial;
        
      
    }
    public boolean checkCellPhoneNumber(String phoneNum){
        String regex = "^\\+27[0-9]{9}$";
        return
    phoneNum.matches(regex);
    }
    
}
