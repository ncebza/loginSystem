/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
public class LoginClass {
    String registerUserName;
    String registerPassword;
    String loginUsername;
    String loginPassword;
    
    while (true) {
    System.out.println("Please enter your username: ");
    username = myInput.nextLine();
    if (checkUserName(username)) {
    System.out.println("Username correct.");
    break;
    } else {
    System.out.println("invalid username, please try again");
        username = input.nextLine();
}
  
}
    //passord login
    while (true) {
    System.out.println("Please enter yout password: ");
    password = myInput.nextLine();
    if (checkPasswor)(password){  
    System.out.println("Password is correct");
    break;
}else{
    System.out.println("Invalid passoword"); 
}
}
}
