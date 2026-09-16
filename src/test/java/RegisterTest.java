/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Student
 */
import com.mycompany.loginsystem_nceba_part1.Register;
import org.junit.jupiter.api.Test;
import static
org.junit.jupiter.api.Assertions.*;
public class RegisterTest {
    @Test 
    public void testUsernameIncorrect(){
        Register register = new Register();
        boolean result = register.checkUserName("abcdef");
        assertFalse(result);
    }
   @Test 
    public void testUsernameCorrect(){
        Register register = new Register();
        boolean result = register.checkUserName("abc_d");
        assertTrue(result) ;
}
    @Test
    public void testPasswordCorrect(){
         Register register = new Register();
         boolean result = register.checkPasswordComplexity("Pass345!");
         assertTrue(result);
    }
    @Test
    public void testPasswordIncorrect(){
         Register register = new Register();
         boolean result = register.checkPasswordComplexity("Password");
         assertFalse(result);
    
}
  @Test
    public void testPhoneCorrect(){
       Register register = new Register(); 
       boolean result = register.checkCellPhoneNumber("+27786074306");
       assertTrue(result);
    } 
     @Test
       public void testPhoneIncorrect(){
       Register register = new Register(); 
       boolean result = register.checkCellPhoneNumber("0786074306");
       assertFalse(result);
 
}
}