import java.util.*;

public class Main {
    static LinkedList<BankAccount> accounts = new LinkedList<>();
    static Stack<String> transactionHistory = new Stack<>();
    static Queue<String> billQueue = new LinkedList<>();
    static Queue<BankAccount> accountRequests = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== BANK MENU ====");
            System.out.println("1) Bank (Requests & Bills)");
            System.out.println("2) ATM");
            System.out.println("3) Admin (Process)");
            System.out.println("4) Physical Structure");
            System.out.println("5) Exit");
            System.out.println("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("1) New Account Request");
                    System.out.println("2) Pay Bill");
                    int B_choice = sc.nextInt();
                    sc.nextLine();
                    if (B_choice == 1) {
                        System.out.println("Name: ");
                        String n = sc.nextLine();
                        accountRequests.add(new BankAccount("TBD", n, 0));
                        System.out.println("Request added");
                    } else {
                        System.out.println("Bill name: ");
                        billQueue.add(sc.nextLine());
                    }
                    break;

                case 2:
                    System.out.println("Enter username: ");
                    String user = sc.nextLine();
                    boolean found = false;
                    for (BankAccount acc : accounts) {
                        if (acc.getUsername().equalsIgnoreCase(user)) {
                            found = true;
                            System.out.println("1) Deposit");
                            System.out.println("2) Withdraw");
                            System.out.println("3) Last Action");
                            int atm = sc.nextInt();
                            if (atm == 1) {
                                System.out.println("Amount: ");
                                double d = sc.nextDouble();
                                acc.setBalance(acc.getBalance() + d);
                                transactionHistory.push("Deposit " + d + " to " + user);
                            } else if (atm == 2) {
                                System.out.println("Amount: ");
                                double w = sc.nextDouble();
                                if (acc.getBalance() >= w) {
                                    acc.setBalance(acc.getBalance() - w);
                                    transactionHistory.push("Withdraw " + w + " from " + user);
                                } else {
                                    System.out.println("Not enough money");
                                }
                            } else if (atm == 3) {
                                if (!transactionHistory.isEmpty()) System.out.println("Last: " + transactionHistory.peek());
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.println("1) Account Process");
                    System.out.println("2) Bill Process");
                    int adm = sc.nextInt();
                    if (adm == 1 && !accountRequests.isEmpty()) {
                        BankAccount a = accountRequests.poll();
                        a.setAccountNumber("ACC" + (accounts.size() + 1));
                        accounts.add(a);
                        System.out.println("Processed: " + a.getUsername());
                    } else if (adm == 2 && !billQueue.isEmpty()) {
                        System.out.println("Paid: " + billQueue.poll());
                    } else {
                        System.out.println("Nothing to process");
                    }
                    break;

                case 4:
                    BankAccount[] arr = new BankAccount[3];
                    arr[0] = new BankAccount("1", "Aidyn", 670);
                    arr[1] = new BankAccount("2", "Aikyn", 100);
                    arr[2] = new BankAccount("3", "User", 230);
                    for (BankAccount b : arr) System.out.println(b);
                    break;

                case 5:
                    return;

            }
        }
    }
}