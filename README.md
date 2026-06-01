# rftinternship
java internship
DAY 1
// Description:
This project is a simple Java program that reverses a given string without using any built-in reverse functions like StringBuilder.reverse().
The program takes input from the user, converts the string into a character array, and then swaps characters from both ends to produce the reversed string.
This project helps in understanding:
Array manipulation
Loop logic
Basic string handling in Java
// Features:
✅ Takes user input using Scanner
✅ Converts string into character array
✅ Reverses string using swapping logic
✅ Does not use any built-in reverse method
✅ Displays the reversed string output
// Run:
JAVA Day1.java
DAY 2
// Description:
This project is a Java-based command-line calculator that performs operations based on user input commands.
The program follows Object-Oriented Programming (OOP) principles by separating logic into different classes such as Calculator and CommandProcessor.
Users can enter commands like ADD, SUB, MUL, etc., followed by numbers, and the program processes the input to return the correct result.
// Features:
✅ Command-based input (e.g., ADD 10 20)
✅ Supports basic operations:
Addition
Subtraction
Multiplication
✅ Clean OOP structure using multiple classes
✅ Parses user input dynamically
✅ Executes correct operation based on command
✅ Easy to extend with new operations
// Run:
JAVA Day2.java
DAY 3
// Description:
This is a console-based Quiz Application developed in Java that allows users to attempt multiple-choice questions interactively. The application provides instant feedback, calculates the final score and percentage, and also displays a detailed review of all answers at the end.
The project is designed using Object-Oriented Programming (OOP) principles, making it modular, readable, and easy to extend with advanced features.
// Features:
📌 Multiple-choice questions (MCQs)
🔀 Randomized question order using Collections.shuffle()
⌨️ User input via console
⚡ Instant feedback (Correct / Wrong)
🎯 Score calculation
// Run:
JAVA Day3.java
DAY 4
// Description:
This project is a simple Smart Home Device Controller built using Java. It demonstrates core Object-Oriented Programming (OOP) concepts such as Abstraction and Method Overriding by simulating real-world home devices like Light, Fan, and Air Conditioner (AC).
Each device can be turned ON/OFF and can display its current status. Additional bonus features include fan speed control and AC temperature adjustment, making the system more realistic and interactive.
// Features:
🔹 Core Features
Abstract base class Device
Derived classes:
💡 Light
🌀 Fan
❄️ AC
Common functionalities:
Turn ON devices
Turn OFF devices
Display device status
🌡️ AC Temperature Control
Set and adjust temperature dynamically
🌀 Fan Speed Control
Multiple speed levels (0–5)
// Run:
JAVA Day4.java
DAY 5
// Description:
The Expense Tracker System is a Java-based application designed to manage and analyze daily expenses efficiently. This project demonstrates important Object-Oriented Programming (OOP) concepts such as Multiple Classes, Object Lists, and Data Aggregation.
Users can add expenses with details like amount, category, and date, and perform operations like viewing all expenses, calculating total spending, and analyzing financial data through advanced features.
// Features:
➕ Add new expenses (amount, category, date)
📋 View all recorded expenses
💸 Calculate total spending
📊 Category-wise Spending
Track how much is spent in each category
💰 Highest Expense
Identify the most expensive transaction
📅 Monthly Summary
View total spending grouped by month
// Run:
JAVA Day5.java
DAY 6
// Description:
The Contact Manager System is a Java-based console application that allows users to store and manage contacts efficiently. This project demonstrates key programming concepts such as Dynamic Lists (ArrayList), Object Storage, and Searching techniques.
Users can add, view, search, and delete contacts, making it a simple yet practical real-world application for managing personal data.
// Features:
➕ Add new contacts (Name, Phone)
📋 Display all saved contacts
🔍 Search contacts by name
❌ Delete Contact
Remove a contact from the list
🔍 Case-Insensitive Search
Search contacts without worrying about uppercase/lowercase
// Run:
JAVA Day6.java
DAY 7
// Description:
The Word Frequency Counter is a Java-based console application that analyzes a sentence and counts how many times each word appears.
This updated version not only calculates word frequencies using HashMap, but also correctly identifies all the most frequent words (in case of ties), making it more accurate and practical for real-world text analysis.
// Features:
📝 Accept user input (sentence)
🔢 Count frequency of each word
📋 Display all words with their counts
🔍 Case-Insensitive Processing
Treats "Java" and "java" as the same word
🏆 Multiple Most Frequent Words Detection
Displays all words having the highest frequency
⚡ Optimized Logic using Collections.max()
Efficient way to find maximum frequency
// Run:
JAVA Day7.java
DAY 8
// Description:
The Expense Tracker System is a Java-based program that demonstrates how to manage user data efficiently using the Set (HashSet) data structure.
The main goal of this project is to store only unique user IDs from a given list and remove duplicates automatically. It also counts duplicate entries as a bonus feature.
This project highlights the importance of Set behavior in Java and how it can be used in real-world scenarios like tracking unique visitors or users.
// Features:
📥 Accept a list of user IDs
🚫 Automatically remove duplicate entries
👥 Store only unique users using HashSet
📊 Display total number of unique visitors
🔁 Duplicate Entries Counter
Counts how many duplicate IDs were present
📋 Display Unique Users List
Shows final filtered set of users
// Run:
JAVA Day8.java
DAY 9
// Description:
A simple Java project to sort students by marks, assign ranks, handle ties, and display top 3 students.
// Features:
- Sort students by marks
- Assign ranks
- Handle tie cases
- Show top 3 students
- Beginner-friendly code
// Run:
JAVA Day9.java
DAY 10
// Description:
This is a simple Inventory Management System built using Java and HashMap.
It demonstrates map-based lookup and real-world object modeling by storing product details efficiently.
// Features:
- Add Product
- Update Product Quantity
- Search Product
- Calculate Total Inventory Value
- Remove Product
- Low Stock Alert (for quantity < 5)
// Run:
JAVA Day10.java
DAY 11
// Description:
This project is a simple Java-based Text Analyzer that reads data from a file (input.txt) and performs basic text analysis operations. It uses BufferedReader for file handling and HashMap for counting word frequency.
//Features:
✅ Count number of lines
✅ Count total words
✅ Find most frequent word
✅ Find longest word
✅ Case-insensitive processing
✅ Removes punctuation
// Run:
JAVA Day11.java
DAY 12
// Description:
CSV Report Generator is a Java-based application that reads employee data from a CSV file, processes the data, and generates meaningful reports.
The main goal of this project is to demonstrate file handling, data parsing, and the use of collections for structured data analysis.
// Features:
- Reads and parses data from a CSV file
- Stores employee data in structured objects
- Calculates average salary for each department
- dentifies the highest paid employee
- Saves the generated report to a file (report.txt)
-  Handles invalid or incorrect rows safely
- Simple and beginner-friendly implementation
 // Run:
JAVA Day12.java
DAY 13
// Description:
The Log Monitoring System is a simple Java-based application that reads a log file and analyzes its contents. It identifies different types of log messages such as ERROR, INFO, and WARNING, counts their occurrences, and displays meaningful insights like the most frequent log type and all error messages.
This project demonstrates basic file handling, string processing, and logical analysis in Java, making it useful for beginners to understand how real-world systems monitor and manage logs.
// Features:
🔹 Reads log data from a text file using Scanner
🔹 Counts occurrences of different log types (ERROR, INFO, WARNING)
🔹 Identifies the most frequent log type
🔹 Displays all ERROR messages separately
🔹 Simple and beginner-friendly implementation
🔹 Uses core Java concepts (loops, conditions, ArrayList)
// Run:
JAVA Day13.java
DAY 14
// Description:
This project is a simple File-Based Search Engine developed in Java using the Scanner class. It allows users to search for a specific word inside a text file and displays the number of occurrences along with the line numbers where the word is found.
// Features:
  - Read data from a file using Scanner
  -Search for a word (case-insensitive)
  -Count total occurrences of the word
  -Display line numbers where the word appears
  -Simple and beginner-friendly implementation
// Run:
JAVA Day14.java
DAY 15
// Description:
A Java-based Data Filter & Export Tool that reads CSV/TXT data, applies dynamic filtering conditions, sorts results, and exports filtered data to a new file using File I/O and Collections.
// Features:
✅ Read data from CSV/TXT file
✅ Store data using ArrayList (Collections)
✅ Apply dynamic filters (user input)
✅ Multiple conditions (salary, age)
✅ Sort filtered data (high → low salary)
✅ Export results to new file using PrintWriter
// Run :
JAVA Day15.java
DAY 16
// Description:
The Multi-Threaded Number Printer is a Java-based project that demonstrates the concept of multithreading and basic concurrency.
In this project, two separate threads are created to print odd and even numbers simultaneously up to a user-defined limit.
The program showcases how multiple threads can run independently and execute tasks in parallel, resulting in an interleaved output. It also uses Thread.sleep() to control execution speed and improve the visibility of concurrent behavior.
This project is ideal for beginners to understand how threads work in Java and how concurrency is handled in real-time applications.
// Features:
✅ Multithreading Implementation using Thread / Runnable
✅ Two Parallel Threads
Thread 1 → Prints Even Numbers
Thread 2 → Prints Odd Numbers
✅ User Input Support (custom limit)
✅ Concurrent Execution (interleaved output)
✅ Thread Control using sleep()
✅ Thread Synchronization using join()
✅ Clean and easy-to-understand code structure
✅ Beginner-friendly project for learning Java concurrency
// Run:
JAVA Day16.java
DAY 17
// Description:
The Task Scheduler System is a Java-based console application designed to execute tasks after a specified delay. This project demonstrates the use of multithreading and time-based execution using Java’s ScheduledExecutorService.
Users can add tasks that will automatically run after a defined number of seconds. The system efficiently manages multiple tasks concurrently without blocking the main program.
In addition, the application includes advanced features such as repeating tasks (similar to alarms) and the ability to cancel scheduled tasks, making it a practical simulation of real-world scheduling systems like reminders, background jobs, and automation tools.
// Features:
- Add Task with Delay
Schedule tasks to execute after a specific time delay.
- Automatic Time-Based Execution
Tasks run automatically once the defined delay is completed.
- Repeating Tasks (Bonus Feature)
Schedule tasks to run repeatedly at fixed intervals (like an alarm system).
- Cancel Scheduled Tasks (Bonus Feature)
Cancel any task before it gets executed using its unique ID.
- Multithreading Support
Handles multiple tasks simultaneously using a thread pool.
- Task Identification System
Each task is assigned a unique ID for easy tracking and management.
- User-Friendly Console Interface
Simple and interactive menu-driven program for ease of use.
// Run:
JAVA Day17.java
DAY 18
// Description:
This project demonstrates the Producer-Consumer Problem using Java Multithreading.
It simulates a real-world scenario where a Producer thread generates data and adds it to a shared buffer, while a Consumer thread retrieves and processes the data.
The implementation uses synchronization techniques like wait() and notifyAll() to manage thread coordination and ensure safe access to shared resources.
The program also includes buffer size limitation and properly handles full and empty states, making it a complete simulation of thread communication.
// Features:
🔹 Implementation of Producer-Consumer problem
🔹 Uses Multithreading (Thread class)
🔹 Synchronized methods for thread safety
🔹 Uses wait() and notifyAll() for communication
🔹 Shared resource using Queue (LinkedList)
🔹 Buffer size limit (Bonus feature)
🔹 Handles Buffer Full & Empty conditions
🔹 Controlled execution (program stops automatically)
🔹 Clean and easy-to-understand code
// Run:
JAVA Day18.java
DAY 19
// Description:
This project is a simple Chat Message Simulator built using Java. It uses multithreading to simulate multiple users sending messages at the same time. Messages are displayed in real-time and stored for later use.
// Features:
👥 Multiple users using threads
⏱️ Real-time message simulation
💬 Messages displayed instantly
📜 Chat history storage (Bonus)
🔍 Filter messages by user (Bonus)
🔒 Thread-safe message handling
// Run:
JAVA Day19.java
DAY 20
// Description:
This project simulates a basic backend server using Java, where multiple client requests are handled concurrently using a Thread Pool. Each request is processed by a separate thread, just like real-world servers.
The system demonstrates how servers manage multiple users efficiently by limiting threads and queuing extra requests.
This project is part of a Java Internship (Day 20) and focuses on real-world backend concepts like concurrency, request handling, and thread management.
// Features:
✅ Simulates multiple client requests
✅ Each request handled by a separate thread
✅ Displays:
Request ID
Processing time
✅ Random processing delay (to mimic real server behavior)
// Run:
JAVA Day20.java
