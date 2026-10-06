import java.util.ArrayList;
import java.util.Scanner;

class Customer {
    int customerId;
    String name;
    String accountNumber;
    double balance;

    Customer(int customerId, String name, String accountNumber, double balance) {
        this.customerId = customerId;
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void display() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

class Transaction {
    String type;
    double amount;

    Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    void display() {
        System.out.println(type + " : Rs. " + amount);
    }
}

class Bank {
    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<Transaction> transactions = new ArrayList<>();

    void registerCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer registered successfully!");
    }

    Customer findCustomer(String accountNumber) {
        for (Customer c : customers) {
            if (c.accountNumber.equals(accountNumber)) {
                return c;
            }
        }
        return null;
    }

    void deposit(String accountNumber, double amount) {
        Customer c = findCustomer(accountNumber);

        if (c != null) {
            c.balance = c.balance + amount;
            transactions.add(new Transaction("Deposit", amount));
            System.out.println("Amount deposited successfully!");
        } else {
            System.out.println("Account not found!");
        }
    }

    void withdraw(String accountNumber, double amount) {
        Customer c = findCustomer(accountNumber);

        if (c != null) {
            if (c.balance >= amount) {
                c.balance = c.balance - amount;
                transactions.add(new Transaction("Withdrawal", amount));
                System.out.println("Amount withdrawn successfully!");
            } else {
                System.out.println("Insufficient balance!");
            }
        } else {
            System.out.println("Account not found!");
        }
    }

    void transfer(String fromAccount, String toAccount, double amount) {
        Customer sender = findCustomer(fromAccount);
        Customer receiver = findCustomer(toAccount);

        if (sender != null && receiver != null) {
            if (sender.balance >= amount) {
                sender.balance = sender.balance - amount;
                receiver.balance = receiver.balance + amount;

                transactions.add(new Transaction("Fund Transfer", amount));

                System.out.println("Fund transferred successfully!");
            } else {
                System.out.println("Insufficient balance!");
            }
        } else {
            System.out.println("Account not found!");
        }
    }

    void miniStatement(String accountNumber) {
        Customer c = findCustomer(accountNumber);

        if (c != null) {
            System.out.println("\n--- Mini Statement ---");
            c.display();

            System.out.println("\nRecent Transactions:");
            for (Transaction t : transactions) {
                t.display();
            }
        } else {
            System.out.println("Account not found!");
        }
    }

    void transactionHistory() {
        System.out.println("\n--- Transaction History ---");

        if (transactions.size() == 0) {
            System.out.println("No transactions available.");
        } else {
            for (Transaction t : transactions) {
                t.display();
            }
        }
    }

    void accountSummary(String accountNumber) {
        Customer c = findCustomer(accountNumber);

        if (c != null) {
            System.out.println("\n--- Account Summary ---");
            c.display();
        } else {
            System.out.println("Account not found!");
        }
    }
}

public class Day27 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {

            System.out.println("\n===== DIGITAL BANKING DASHBOARD =====");
            System.out.println("1. Customer Registration");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Fund Transfer");
            System.out.println("5. Mini Statement");
            System.out.println("6. Transaction History");
            System.out.println("7. Account Summary");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Enter Customer ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Account Number: ");
                String account = sc.nextLine();

                System.out.print("Enter Initial Balance: ");
                double balance = sc.nextDouble();

                Customer customer =
                        new Customer(id, name, account, balance);

                bank.registerCustomer(customer);

            } else if (choice == 2) {

                System.out.print("Enter Account Number: ");
                String account = sc.nextLine();

                System.out.print("Enter Amount: ");
                double amount = sc.nextDouble();

                bank.deposit(account, amount);

            } else if (choice == 3) {

                System.out.print("Enter Account Number: ");
                String account = sc.nextLine();

                System.out.print("Enter Amount: ");
                double amount = sc.nextDouble();

                bank.withdraw(account, amount);

            } else if (choice == 4) {

                System.out.print("Enter Sender Account Number: ");
                String from = sc.nextLine();

                System.out.print("Enter Receiver Account Number: ");
                String to = sc.nextLine();

                System.out.print("Enter Amount: ");
                double amount = sc.nextDouble();

                bank.transfer(from, to, amount);

            } else if (choice == 5) {

                System.out.print("Enter Account Number: ");
                String account = sc.nextLine();

                bank.miniStatement(account);

            } else if (choice == 6) {

                bank.transactionHistory();

            } else if (choice == 7) {

                System.out.print("Enter Account Number: ");
                String account = sc.nextLine();

                bank.accountSummary(account);

            } else if (choice == 8) {

                System.out.println("Thank you for using Digital Banking Dashboard!");
                break;

            } else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}