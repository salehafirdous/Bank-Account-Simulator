package com.elevatelabs.tasks.task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankApp {
    private final List<Account> accounts = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);
    private int nextAccountId = 1001; 

    public static void main(String[] args) {
        new BankApp().menu();
    }

    private void menu() {
        System.out.println("Welcome to the1 Bank App");
        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Balance");
            System.out.println("5. View Transactions");
            System.out.println("6. List Accounts");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = readIntSafe();

            switch (choice) {
            case 1: createAccount(); 
            break;
            case 2: deposit(); 
            break;
            case 3: withdraw(); 
            break;
            case 4: viewBalance(); 
            break;
            case 5: viewTransactions(); 
            break;
            case 6: listAccounts(); 
            break;
            case 7:
                    System.out.println("Exiting...");
                    return;
                
                default:
                System.out.println("Invalid choice.");
            }
        }
    }
    
    // Method for safely read integers
    private int readIntSafe() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid integer: ");
            }
        }
    }
    

    // Method for safely read doubles
    private double readDoubleSafe() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

    private void createAccount() {
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine().trim();

        System.out.print("Initial deposit amount: ");
        double initial = readDoubleSafe();

        int type;
        while (true) {
            System.out.println("Choose account type: 1. Basic  2. Savings (min balance)");
            type = readIntSafe();
            if (type == 1 || type == 2) break;
            System.out.println("Invalid choice. Please enter 1 or 2");
        }

        Account acc;
        if (type == 2) {
            System.out.print("Enter minimum balance for savings account: ");
            double minBal = readDoubleSafe();
            acc = new SavingsAccount(nextAccountId++, name, initial, minBal);
        } else {
            acc = new Account(nextAccountId++, name, initial);
        }

        accounts.add(acc);
        System.out.println("Account created: " + acc);
    }

    private Account findAccountById(int id) {
        for (Account a : accounts) {
            if (a.getAccountId() == id) return a;
        }
        return null;
    }

    private void deposit() {
        System.out.print("Enter account ID: ");
        int id = readIntSafe();
        Account acc = findAccountById(id);
        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter deposit amount: ");
        double amt = readDoubleSafe();
        acc.deposit(amt);
    }

    private void withdraw() {
        System.out.print("Enter account ID: ");
        int id = readIntSafe();
        Account acc = findAccountById(id);
        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter withdrawal amount: ");
        double amt = readDoubleSafe();
        if (acc.withdraw(amt)) {
            System.out.println("Withdrawal completed");
        } else {
            System.out.println("Withdrawal failed");
        }
    }

    private void viewBalance() {
        System.out.print("Enter account ID: ");
        int id = readIntSafe();
        Account acc = findAccountById(id);
        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }
        System.out.println("Account Balance: " + acc.getBalance());
    }

    private void viewTransactions() {
        System.out.print("Enter account ID: ");
        int id = readIntSafe();
        Account acc = findAccountById(id);
        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }
        acc.printTransactions();
    }

    private void listAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts created yet.");
            return;
        }
        System.out.println("All Accounts");
        for (Account a : accounts) {
            System.out.println(a);
        }
    }
}
