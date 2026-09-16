/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginsystem_nceba_part1;

/**
 *
 * @author Student
 */
public class LoginClass {
    public boolean
            loginUser(String enteredUser, String enteredPass, String regUser, String regPass){
                return enteredUser.equals(regUser) && enteredPass.equals(regPass);
            }
            public String returnLoginStatus(String enteredUser, String enteredPass, 
                    String regUser, String regPass, String name, String surname){
                if (loginUser(enteredUser, enteredPass, regUser, regPass)){
                    return "Welcome"
                            + name
                            + ", "
                            +surname
                            +"is set to see you agaim.";
                }
                return "Username or password incorrect.";
            }
                    
    
}
