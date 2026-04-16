import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        LinkedList accounts = new LinkedList();
        Stack history = new Stack();
        MyQueue billQueue = new MyQueue();
        AdminQueue registrationQueue = new AdminQueue();

        Scanner sc = new Scanner(System.in);

        BankAccount[] Accounts = new BankAccount[3];

        Accounts[0] = new BankAccount("1001", "Kairat", 50000);
        Accounts[1] = new BankAccount("1002", "Tamerlan", 52000);
        Accounts[2] = new BankAccount("1003", "Arman", 120000);

        for (int i = 0; i < Accounts.length; i++) {
            System.out.println("Index " + i + ": " + Accounts[i]);
        }

        while (true) {
            System.out.println("\n==== MAIN MENU ====");
            System.out.println("1) Enter Bank");
            System.out.println("2) Enter ATM");
            System.out.println("3) Admin Area");
            System.out.println("4) Exit");
            System.out.println("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    handleBankMenu(sc, accounts, registrationQueue, history);
                    break;
                case 2:
                    handleATMMenu(sc, accounts, history);
                    break;
                case 3:
                    handleAdminMenu(sc, accounts, registrationQueue, billQueue);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    public static void handleBankMenu(Scanner sc, LinkedList accounts, AdminQueue requests, Stack history) {
        System.out.println("\n--- BANK MENU ---");
        System.out.println("1. Submit Account Opening Request");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.print("Choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Enter name: ");
                String name = sc.nextLine();
                System.out.println("Initial deposit: ");
                double bal = sc.nextDouble();
                requests.enqueueRequest(name, bal);
                System.out.println("Request sent");
                break;
            case 2:
                System.out.println("Enter username: ");
                String userDep = sc.nextLine();
                BankAccount accDep = accounts.findByusername(userDep);
                if (accDep != null) {
                    System.out.println("Amount to deposit: ");
                    double amount = sc.nextDouble();
                    accDep.setBalance(accDep.getBalance() + amount);
                    history.push("Deposit " + amount + " - " + userDep);
                    System.out.println("Success! New balance: " + accDep.getBalance());
                } else {
                    System.out.println("User not found :(");
                }
                break;
            case 3:
                System.out.println("Enter username: ");
                String userWith = sc.nextLine();
                BankAccount accWith = accounts.findByusername(userWith);
                if (accWith != null) {
                    System.out.println("Amount to withdraw: ");
                    double amount = sc.nextDouble();
                    if (accWith.getBalance() >= amount) {
                        accWith.setBalance(accWith.getBalance() - amount);
                        history.push("Withdraw " + amount + " - " + userWith);
                        System.out.println("Success! New balance: " + accWith.getBalance());
                    } else {
                        System.out.println("Insufficient funds.");
                    }
                } else {
                    System.out.println("User not found");
                }
                break;
        }
    }

    public static void handleATMMenu(Scanner sc, LinkedList accounts, Stack history) {
        System.out.println("\nEnter username: ");
        String user = sc.nextLine();
        BankAccount acc = accounts.findByusername(user);

        if (acc == null) {
            System.out.println("Account not found");
            return;
        }

        System.out.println("1) Balance Enquiry\n2) Withdraw");
        int choise = sc.nextInt();
        switch (choise) {
            case 1:
                System.out.println("Balance: " + acc.getBalance());
                break;
            case 2:
                System.out.println("Amount: ");
                double amt = sc.nextDouble();
                if (acc.getBalance() >= amt) {
                    acc.setBalance(acc.getBalance() - amt);
                    history.push("ATM Withdraw " + amt + " - " + user);
                    System.out.println("Done");
                } else {
                    System.out.println("No money");
                }
                break;
        }
    }

    public static void handleAdminMenu(Scanner sc, LinkedList accounts, AdminQueue requests, MyQueue bills) {
        System.out.println("\n--- ADMIN AREA ---");
        System.out.println("1. Process Account Request");
        System.out.println("2. View Bill Queue");
        System.out.print("Choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                AccountRequest req = requests.dequeueRequest();
                if (req != null) {
                    String id = "ID" + (int)(Math.random() * 999);
                    accounts.addToLast(new BankAccount(id, req.username, req.initialBalance));
                    System.out.println("Created account " + id + " for " + req.username);
                } else {
                    System.out.println("Queue is empty.");
                }
                break;
            case 2:
                bills.displayQueue();
                break;
        }
    }
}