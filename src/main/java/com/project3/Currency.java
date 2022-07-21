package com.project3;

public enum Currency {
    RUPEES(1),
    DOLLARS(80);
    double money;

    Currency(double money) {
        this.money=money;
    }

    public double getBaseAmount() {
        return this.money;
    }
}
