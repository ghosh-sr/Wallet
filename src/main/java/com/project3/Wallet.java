package com.project3;

/**
 * Hello world!
 *
 */
public class Wallet 
{
    private double money;

    Wallet(){
        this.money=0.00;
    }

    public double getBalance(Currency currency) {
        return this.money/currency.getBaseAmount();
    }

    public void addMoney(double deposit, Currency currency) {

        this.money+=currency.getBaseAmount()*deposit;
    }

    private boolean checkBounce(double withdrawal,Currency currency) {
        return withdrawal>this.money;
    }

    public double withdrawMoney(double withdrawal, Currency currency) throws InsufficientBalanceException {
        withdrawal=currency.getBaseAmount()*withdrawal;
        if(!checkBounce(withdrawal, currency)){
            this.money-=withdrawal;
            return withdrawal/currency.getBaseAmount();
        } else {
            throw new InsufficientBalanceException();
        }
    }
}
