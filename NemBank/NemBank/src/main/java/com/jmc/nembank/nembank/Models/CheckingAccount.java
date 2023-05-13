package com.jmc.nembank.nembank.Models;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CheckingAccount extends Account {
    //the number of transaction a client is allowed to do per day
    private final IntegerProperty transactionLimit;
    public CheckingAccount(String owner, String accountNumber, Double balance, int tLimit){
        super(owner, accountNumber, balance);
        this.transactionLimit = new SimpleIntegerProperty(this, "Transaction limit", tLimit);
    }
    public IntegerProperty transactionLimitProp() {return transactionLimit;}

    @Override
    public String toString(){
        return  accountNumberProperty().get();
    }
}
