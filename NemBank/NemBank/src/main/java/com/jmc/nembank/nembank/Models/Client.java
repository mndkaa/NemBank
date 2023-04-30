package com.jmc.nembank.nembank.Models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Client {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty payeeAddress;

    private final ObjectProperty<Account> checkingAccount;

    private final ObjectProperty<Account> savingAccount;

    private final ObjectProperty<LocalDate> dateCreated;

    public Client(String firstName, String lastName, String payeeAddress, ObjectProperty<Account> checkingAccount, ObjectProperty<Account> savingAccount, ObjectProperty<LocalDate> dateCreated) {
        this.firstName = new SimpleStringProperty(this,"FirstName");
        this.lastName = new SimpleStringProperty(this, "LastName");
        this.payeeAddress = new SimpleStringProperty(this,"Payee Address");
        this.checkingAccount = new SimpleObjectProperty<>(this, "Checking Account");
        this.savingAccount = new SimpleObjectProperty<>(this, "Savings Account");
        this.dateCreated = new SimpleObjectProperty<>(this, "Date");
    }

    public StringProperty firstNameProperty() {return firstName;}
    public StringProperty lastNameProperty() {return lastName;}
    public StringProperty pAddress() {return payeeAddress;}
    public ObjectProperty<Account> checkingAccountProperty() {return checkingAccount;}
    public ObjectProperty<Account> savingAccountProperty() {return savingAccount;}
    public ObjectProperty<LocalDate> dateProperty() {return dateCreated;}

}
