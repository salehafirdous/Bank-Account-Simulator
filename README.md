# Task 5: Bank Account Simulation

This BankApp Project is the Part of the Elevate Labs Java Developer Internship.  
Objective: Simulate basic bank operations using Java OOP.

## What I Did
- Implemented an `Account` class with `deposit`, `withdraw`, and a transaction history.
- Added `SavingsAccount` (extends `Account`) to demonstrate inheritance and method overriding (savings enforces a minimum balance).
- Built a menu-driven `BankApp` to create accounts (Basic or Savings), deposit, withdraw, view balance, and view transactions.
- Practiced OOP concepts: classes, inheritance, encapsulation, and method overriding.

## Features
- Create Basic or Savings account
- Deposit money
- Withdraw money (savings account enforces minimum balance)
- View current balance
- List all created accounts

## Project Structure
```
com.elevatelabs.tasks.task5
├── Account.java
├── SavingsAccount.java
└── BankApp.java
```

## Sample Output
```
Welcome to the Bank App

1. Create Account
2. Deposit
3. Withdraw
4. View Balance
5. View Transactions
6. List Accounts
7. Exit
Enter your choice: 1
Enter account holder name: Saleha Syed Qamar
Initial deposit amount: 1000
Choose account type: 1. Basic  2. Savings (min balance)
2
Enter minimum balance for savings account: 500
Account created: SavingsAccount [ID=1001, Holder=Saleha Syed Qamar, Balance=1000.0, MinBalance=500.0]

1. Create Account
2. Deposit
3. Withdraw
4. View Balance
5. View Transactions
6. List Accounts
7. Exit
Enter your choice: 3
Enter account ID: 1001
Enter withdrawal amount: 500
Withdrawal successful. New balance: 500.0
Withdrawal completed

1. Create Account
2. Deposit
3. Withdraw
4. View Balance
5. View Transactions
6. List Accounts
7. Exit
Enter your choice: 3
Enter account ID: 1001
Enter withdrawal amount: 500
Cannot withdraw. Savings account must maintain minimum balance of 500.0
Withdrawal failed

1. Create Account
2. Deposit
3. Withdraw
4. View Balance
5. View Transactions
6. List Accounts
7. Exit
Enter your choice:
```

- Name: Saleha Firdous Syed Qamar
- Domain: Java Full Stack Development 
