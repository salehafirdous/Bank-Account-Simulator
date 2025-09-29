package com.elevatelabs.tasks.task5;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private final int accountId;
    private final String holderName;
    protected double balance; 
    private final List<String> history = new ArrayList<>();

    public Account(int accountId, String holderName, double initialDeposit) {
        this.accountId = accountId;
        this.holderName = holderName;
        this.balance = initialDeposit;
        history.add("Initial Deposit: " + initialDeposit + " | Balance: " + this.balance);
    }

    public int getAccountId() {
        return accountId;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Enter an amount greater than zero");
            return;
        }
        balance += amount;
        history.add("Deposit: " + amount + " | Balance: " + balance);
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Enter an amount greater than zero.");
            return false;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance. Current balance: " + balance);
            return false;
        }
        balance -= amount;
        history.add("Withdraw: " + amount + " | Balance: " + balance);
        System.out.println("Withdrawal successful. New balance: " + balance);
        return true;
    }

    public void printTransactions() {
        if (history.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }
        System.out.println("Transaction History for Account " + accountId + " (" + holderName + ")");
        for (String h : history) {
            System.out.println(h);
        }
    }

    @Override
    public String toString() {
        return "Account [ID=" + accountId + ", Holder=" + holderName + ", Balance=" + balance + "]";
    }
}

