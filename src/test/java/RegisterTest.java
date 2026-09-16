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
        boolean result = register.checkUserName("String username");
        assertFalse(result);
    }
    
    
}
