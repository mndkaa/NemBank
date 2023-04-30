package com.jmc.nembank.nembank.Models;

import com.jmc.nembank.nembank.Views.AccountType;
import com.jmc.nembank.nembank.Views.ViewFactory;

import java.sql.ResultSet;
import java.time.LocalDate;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private final DataBaseDriver dataBaseDriver;
    //Client Data section
    private  final Client client;
    private boolean clientLoginSuccessFlag;
    //Admin Data section
    private boolean adminLoginSuccessFlag;

    private Model(){
        this.viewFactory = new ViewFactory();
        this.dataBaseDriver = new DataBaseDriver();
        //Client data section
        this.clientLoginSuccessFlag = false;
        this.client = new Client("","","",null,null,null);
        //Admin data section
        this.adminLoginSuccessFlag = false;
    }

    public static synchronized  Model getInstance(){
        if(model==null){
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }
    public DataBaseDriver getDataBaseDriver() {return dataBaseDriver;}


    /*
    Client method section
     */

    public boolean getClientLoginSuccessFlag() {
        return this.clientLoginSuccessFlag;
    }
    public void setClientLoginSuccessFlag(boolean flag) {
        this.clientLoginSuccessFlag = flag;
    }

    public Client getClient() {

        return client;
    }

    public void evaluateClientCred(String pAddress, String password){
        CheckingAccount checkingAccount;
        SavingAccount savingAccount;
        ResultSet resultSet = dataBaseDriver.getClientData(pAddress, password);
        try {
            if (resultSet.isBeforeFirst()){
               this.client.firstNameProperty().set(resultSet.getString("FirstName"));
               this.client.lastNameProperty().set(resultSet.getString("LastName"));
               this.client.pAddress().set(resultSet.getString("PayeeAddress"));
               String[] dateParts = resultSet.getString("Date").split("-");
               LocalDate date = LocalDate.of(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
               this.client.dateProperty().set(date);
               this.clientLoginSuccessFlag = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
    Admin method section
     */
    public boolean getAdminLoginSuccessFlag() { return this.adminLoginSuccessFlag;}

    public void setAdminLoginSuccessFlag(boolean adminLoginSuccessFlag) {
        this.adminLoginSuccessFlag = adminLoginSuccessFlag;
    }

    public void evaluateAdminCred(String username, String password){
        ResultSet resultSet = dataBaseDriver.getAdminData(username, password);
        try {
            if(resultSet.isBeforeFirst()) {
                this.adminLoginSuccessFlag = true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

