package com.example.budgetmate.Network;

class postRespObj {
    public String successful;
    public String error;
    public String result;
}

class RetrieveUserObj {
    public String token;
    public String action = "retrieveUser";

    public RetrieveUserObj(String token) {
        this.token = token;
    }
}






