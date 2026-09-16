/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
import com.mycompany.loginsystem_nceba_part1.LoginClass;
import org.junit.jupiter.api.Test;
import static
org.junit.jupiter.api.Assertions.*;

public class LoginClassTest {
   @Test
   public void testLoginFail(){
       LoginClass login = new LoginClass();
       boolean result = login.loginUser("user_1", "WrongPass", "user_1", "Pass123!" );
       assertFalse(result);
   }
   @Test
   public void testLoginSuccess(){
       LoginClass login = new LoginClass();
       boolean result = login.loginUser("user_1", "Pass123!", "user_1", "Pass123!" );
       assertTrue(result);
}
}
