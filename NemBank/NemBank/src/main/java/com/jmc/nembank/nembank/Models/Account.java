package com.jmc.nembank.nembank.Models;

public abstract class Account {
private final String owner;
private final String accountNumber;
private final Double balance;

    public Account(String owner, String accountNumber, Double balance) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public String ownerProperty() {return owner;}
    public String accountNumberProperty() {return accountNumber;}
    public Double balanceProperty() {return balance;}
}
