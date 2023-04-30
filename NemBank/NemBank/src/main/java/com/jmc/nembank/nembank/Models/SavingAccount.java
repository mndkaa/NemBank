package com.jmc.nembank.nembank.Models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class SavingAccount extends Account{
    //the withDrawl limit from the savings
    private final DoubleProperty withDrawlLimit;

    public SavingAccount(String owner, String accountNumber, double balance, double withDrawarlLimit){
        super(owner, accountNumber, balance);
        this.withDrawlLimit = new SimpleDoubleProperty(this, "withdrawal limit", withDrawarlLimit);
    }
    public DoubleProperty withDrawlLimitProp() {return withDrawlLimit;}
}
