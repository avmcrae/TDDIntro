package com.thoughtworks.tddintro.accountbalance;

/**
 * Created by avalonmcrae on 7/20/15.
 */
public class Account {
    private float balance;

    public Account(int startBalance) {
        balance = startBalance;
    }

    public void deposit(int depAmount) {
        balance += depAmount;
    }

    public void withdraw(int withdrawalAmt) {
        if (balance > withdrawalAmt) {
            balance -= withdrawalAmt;
        }
    }

    public float getBalance() {
        return balance;
    }
}
