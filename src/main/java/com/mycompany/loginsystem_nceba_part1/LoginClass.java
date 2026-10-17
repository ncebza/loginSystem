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
    //This compares the login details the user typed against the ones they registred with
    public boolean
            loginUser(String enteredUser, String enteredPass, String regUser, String regPass){
                return enteredUser.equals(regUser) && enteredPass.equals(regPass);
            }
            //if what the user typed matches with what they registered than it goes through
            public String returnLoginStatus(String enteredUser, String enteredPass, 
                    String regUser, String regPass, String name, String surname){
                if (loginUser(enteredUser, enteredPass, regUser, regPass)){
                    return "Welcome "
                            + name
                            + ", "
                            +surname
                            +"is set to see you agaim.";
                }
                //if what the user typed does not matche with the registre data  it does not go through the user needs to try again
                return "Username or password incorrect.";
            }
                    
    
}
