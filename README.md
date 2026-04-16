Bank Management System (ADS Project)
Student: Madina Kairbayeva.

Group: IT-2504

Key Data Structures Used:
LinkedList (Singly Linked): Used for permanent storage of BankAccount objects. Chosen for dynamic memory allocation.
Queue (FIFO - First In, First Out):
AdminQueue: Manages account opening requests.
MyQueue: Handles bill payment processing.
Stack (LIFO - Last In, First Out):
Transaction History: Stores a log of all actions. The most recent transaction is always at the top.

Work Process & Logic:
The project is divided into several logical layers:
Data Layer: Custom Node classes for each structure to avoid using built-in Java Collections where possible (as per ADS requirements).
Logic Layer: Separate classes for Stack, Queue, and LinkedList with manual implementation of push, pop, enqueue, and dequeue.
Interface Layer: A CLI (Command Line Interface) in Main.java that coordinates data flow between menus.


Task 1: Main Menu & Initial Data  

<img width="573" height="260" alt="image" src="https://github.com/user-attachments/assets/8b261acf-99a5-4b5d-9129-56d90dac9497" /> 



Task 2, 3: Account Request (Queue Enqueue)/ATM Transactions & History (Stack Push)  

<img width="368" height="242" alt="image" src="https://github.com/user-attachments/assets/704a0562-0a1b-4d23-8567-077b77c85d14" />



Task 4 – Bill Payment Queue (Queue – FIFO)  

<img width="432" height="265" alt="image" src="https://github.com/user-attachments/assets/e5a5540d-08f7-4739-9eb5-2cbd0bcb5484" />




