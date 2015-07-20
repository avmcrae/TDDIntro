package com.thoughtworks.tddintro.accountbalance;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


public class AccountTests {
    private Account myAccount = new Account(100);
    Float originalBalance = myAccount.getBalance();

    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        myAccount.deposit(50);
        Float newBalance = myAccount.getBalance();

        assertTrue(originalBalance < newBalance);
    }
//
    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        myAccount.withdraw(50);
        Float newBalance = myAccount.getBalance();

        assertTrue(originalBalance > newBalance);
    }
//
    @Test
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
        myAccount.withdraw(50);
        originalBalance = myAccount.getBalance(); // balance is now $50

        myAccount.withdraw(100);
        Float newBalance = myAccount.getBalance();

        assertEquals(originalBalance, newBalance);
    }
}
