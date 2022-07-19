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

    public double getBalance() {
        return this.money;
    }

    public void addMoney(double deposit) {
        this.money+=deposit;
    }

    private boolean checkBounce(double withdrawal) {
        return withdrawal>this.money;
    }

    public double withdrawMoney(double withdrawal) throws InsufficientBalanceException {
        if(!checkBounce(withdrawal)){
            this.money-=withdrawal;
            return withdrawal;
        } else {
            throw new InsufficientBalanceException();
        }
    }
}
