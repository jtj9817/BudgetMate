package com.example.budgetmate.Models;

import java.util.Date;

public class User {

    private String email;
    private String firstName;
    private String lastName;
    private Date dateJoined;
    private Date lastConnected;
    private UserDebts userDebts;
    private UserGoals userGoals;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    public Date getLastConnected() {
        return lastConnected;
    }

    public void setLastConnected(Date lastConnected) {
        this.lastConnected = lastConnected;
    }

    public UserDebts getUserDebts() {
        return userDebts;
    }

    public void setUserDebts(UserDebts userDebts) {
        this.userDebts = userDebts;
    }

    public UserGoals getUserGoals() {
        return userGoals;
    }

    public void setUserGoals(UserGoals userGoals) {
        this.userGoals = userGoals;
    }
}
