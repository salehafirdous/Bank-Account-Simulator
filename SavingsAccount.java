package com.elevatelabs.tasks.task5;

public class SavingsAccount extends Account {
    private final double minBalance;

    public SavingsAccount(int accountId, String holderName, double initialDeposit, double minBalance) {
        super(accountId, holderName, initialDeposit);
        this.minBalance = minBalance;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Enter an amount greater than zero");
            return false;
        }
        if (getBalance() - amount < minBalance) {
            System.out.println("Cannot withdraw. Savings account must maintain minimum balance of " + minBalance);
            return false;
        }
        return super.withdraw(amount);
    }

    @Override
    public String toString() {
        return "SavingsAccount [ID=" + getAccountId() + ", Holder=" + getHolderName() + ", Balance=" + getBalance()
                + ", MinBalance=" + minBalance + "]";
    }
}
