package com.project3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;



/**
 * Unit test for simple App.
 */
public class WalletTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldReturnTrueIfMoneyWasDepositedIntoWallet() {
        
        Wallet wallet=new Wallet();
        double amount=200.00;
        double previous_balance=wallet.getBalance();
        
        wallet.addMoney(amount);
        double current_balance=wallet.getBalance();

        assertTrue(current_balance>previous_balance);
    }

    @Test
    public void shouldReturnTheWithdrawalAmountOnSuccessfulWithdrawal() throws InsufficientBalanceException {
        
        Wallet wallet=new Wallet();

        double amount=150.00;
        wallet.addMoney(200.00);

        double withdrawal_amount=wallet.withdrawMoney(amount);
        double current_balance=wallet.getBalance();
        
        assertTrue(withdrawal_amount==amount);
        assertEquals(current_balance, 50, 0);
    }

    @Test
    public void shouldThrowInsufficientBalanceException() {
        
        Wallet wallet=new Wallet();

        double amount=150.00;
        wallet.addMoney(20.00);

        assertThrows(InsufficientBalanceException.class, ()->wallet.withdrawMoney(amount), "Expected to throw InsufficientBalanceException");
    }
}
