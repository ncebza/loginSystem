# Programming 1A - Part 3 Project

**Student Name:** Nceba
**Student Number:** ST10513411
**Module Code:** PROG5121

## About the project
This is my final Java project for Programming 1A. It is a simple messaging app that runs in the console. It handles user registration, login, and sending messages. For Part 3, I added the final features which include reading data from a JSON file, putting that data into parallel arrays, and creating a new menu for Stored Messages. 

## What the app does
The app has a main menu with different options:
1. Register a user.
2. Login.
3. Send messages (stores them in a JSON file).
4. Stored Messages menu.

## The Stored Messages Menu (Part 3)
In Part 3, I added a fourth menu. When you open it, you can do these things:
* **Option 1:** See the sender and recipient of all saved messages.
* **Option 2:** Find and display the longest message that is saved.
* **Option 3:** Type in a Message ID to search for it and see the message.
* **Option 4:** Type in a recipient's cell number to find all messages sent to them.
* **Option 5:** Delete a message by typing in its message hash.
* **Option 6:** Print a full report showing the message hash, recipient, and the message text.

## How it works under the hood
* I used **parallel arrays** to store the Message IDs, Hashes, Recipients, Senders, and the actual Message text. 
* The app reads the JSON file into these arrays using a JSON library. 
* All the loops and search functions check if the arrays are empty first so the app doesn't crash.

## Unit Tests
I wrote unit tests to make sure the code works properly. The tests check:
* If the messages are saved in the arrays correctly.
* If the longest message is found.
* If searching by ID works.
* If searching by recipient works.
* If deleting a message works.
* If the report prints correctly.

I also set up a `testjava.yml` file so that the tests run automatically on GitHub Actions when I push my code.

## How to run the app
1. Clone the repository to your computer.
2. Open the project in your IDE (like IntelliJ or Eclipse).
3. Run the main class.
4. Follow the instructions in the console to register, login, and send messages.
