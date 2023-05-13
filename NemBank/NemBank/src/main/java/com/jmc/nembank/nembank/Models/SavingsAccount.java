package com.jmc.nembank.nembank.Models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class SavingsAccount extends Account {
    //the withdrawal limit from the savings
    private final DoubleProperty withdrawalLimit;

    public SavingsAccount(String owner, String accountNumber, double balance, double withdrawalLimit){
        super(owner, accountNumber, balance);
        this.withdrawalLimit = new SimpleDoubleProperty(this, "withdrawal limit", withdrawalLimit);
    }
    public DoubleProperty withdrawalLimitProp() {return withdrawalLimit;}

    @Override
    public String toString(){
        return accountNumberProperty().get();
    }
}
