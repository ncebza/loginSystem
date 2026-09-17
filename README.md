# PROG5121 POE - Part 1

Student Name: Nceba Nyangiwe
Student Number: ST10513411
Module: PROG5121

This is my Part 1 submission for the PROG5121 POE. It is a console app that handles user registration and login for a chat system.

## What the app does

The program asks the user to register with a first name, last name, username, password, and South African cell phone number. It checks each one against the rules from the assignment and only moves on once everything is valid. After that it asks the user to log in with the same username and password and welcomes them if the details match.

## Validation rules

1. Username must contain an underscore and be no longer than 5 characters.
2. Password must be at least 8 characters, have a capital letter, a number, and a special character.
3. Cell phone number must start with +27 and have 9 digits after that.

## Classes

1. Register.java holds all the validation methods (checkUserName, checkPasswordComplexity, checkCellPhoneNumber).
2. LoginClass.java checks if the login details match and returns the welcome message.
3. LoginSystem_Nceba_Part1.java is the main class. It handles the Scanner input and calls the other two classes.

## Tests

Unit tests are in the test folder. They cover both the valid and invalid cases for each rule.

1. RegisterTest.java
2. LoginClassTest.java

To run the tests in NetBeans, right click the test file and choose Test File.

## How to run

Open the project in NetBeans and run LoginSystem_Nceba_Part1.java. Follow the prompts in the output window.

## References

Oracle. 2024. *Java Regular Expressions*. [Online]. Available at: https://docs.oracle.com/javase/tutorial/essential/regex/ [Accessed 16 September 2026].

Regex101. 2024. *Regex for South African Phone Numbers*. [Online]. Available at: https://regex101.com/library [Accessed 16 September 2026].

Note on the regex: I used the regex pattern "^\\+27[0-9]{9}$" in Register.java. I adapted this pattern for the South African international code (+27) followed by 9 digits, based on the regular expression resources listed above.
