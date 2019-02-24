package com.example.budgetmate.Network;

import com.example.budgetmate.Models.*;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NetworkManager {

    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private static String URL = "https://script.google.com/macros/s/AKfycbxtoBjl9VmuRsInYbCEcGHOve9y2aMbD8BFd6Lpkl__BVVLFFU/exec";
    private static OkHttpClient client = new OkHttpClient();

    public static String makePostRequest(String json) throws IOException {

        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(URL)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    /*
        Users
     */

    public static User retrieveUser(String token) throws IOException {
        Gson gson = new Gson();
        RetrieveUserObj retrieveUserObj = new RetrieveUserObj(token);
        String retrieveUserJSON = gson.toJson(retrieveUserObj);
        String response = makePostRequest(retrieveUserJSON);
        postRespObj respObj = gson.fromJson(response, postRespObj.class);
        String user = respObj.result;
        return gson.fromJson(user, User.class);
    }

    public static User registerUser(String token, String firstName, String lastName) throws IOException {
        Gson gson = new Gson();
        RegisterUserObj registerUserObj = new RegisterUserObj(token, firstName, lastName);
        String registerUserJSON = gson.toJson(registerUserObj);
        String response = makePostRequest(registerUserJSON);
        postRespObj respObj = gson.fromJson(response, postRespObj.class);
        String user = respObj.result;
        return gson.fromJson(user, User.class);
    }

    /*
        Goals
     */

    public static UserGoals retrieveUserGoals(String token) throws IOException {
        Gson gson = new Gson();
        RetrieveGoalsObj retrieveGoalsObj = new RetrieveGoalsObj(token);
        String retrieveGoalsJSON = gson.toJson(retrieveGoalsObj);
        String response = makePostRequest(retrieveGoalsJSON);
        postRespObj respObj = gson.fromJson(response, postRespObj.class);
        String goals = respObj.result;
        return gson.fromJson(goals, UserGoals.class);
    }

    public static Goal createNewGoal(String token, String goalName, Double goalAmount, Double amountSaved) throws IOException {
        Gson gson = new Gson();
        CreateGoalObj createGoalObj = new CreateGoalObj(token, goalName, goalAmount, amountSaved);
        String createGoalJSON = gson.toJson(createGoalObj);
        String response = makePostRequest(createGoalJSON);
        postRespObj respObj = gson.fromJson(response, postRespObj.class);
        String user = respObj.result;
        return gson.fromJson(user, Goal.class);
    }

    public static boolean deleteGoal(String token, String goalID) throws IOException {
        Gson gson = new Gson();
        DeleteGoalObj deleteGoalObj = new DeleteGoalObj(token, goalID);
        String deleteGoalJSON = gson.toJson(deleteGoalObj);
        String response = makePostRequest(deleteGoalJSON);
        postRespObj respObj = gson.fromJson(response, postRespObj.class);
        return respObj.successful;
    }

    public static boolean updateGoalName(String token, String goalID, String goalName) throws IOException {
        Gson gson = new Gson();
        UpdateGoalNameObj updateGoalNameObj = new UpdateGoalNameObj(token, goalID, goalName);
        String updateGoalNameJSON = gson.toJson(updateGoalNameObj);
        String response = makePostRequest(updateGoalNameJSON);
        postRespObj respObj = gson.fromJson(response, postRespObj.class);
        return respObj.successful;
    }

    public static boolean updateGoalAmount(String token, String goalID, Double goalAmount) throws IOException {
        Gson gson = new Gson();
        UpdateGoalAmountObj updateGoalAmountObj = new UpdateGoalAmountObj(token, goalID, goalAmount);
        String updateGoalAmountJSON = gson.toJson(updateGoalAmountObj);
        String response = makePostRequest(updateGoalAmountJSON);
        postRespObj respObj = gson.fromJson(response, postRespObj.class);
        return respObj.successful;
    }

    public static boolean updateGoalAmountSaved(String token, String goalID, Double goalAmountSaved) throws IOException {
        Gson gson = new Gson();
        UpdateGoalAmountObj updateGoalAmountSavedObj = new UpdateGoalAmountObj(token, goalID, goalAmountSaved);
        String updateGoalAmountSavedJSON = gson.toJson(updateGoalAmountSavedObj);
        String response = makePostRequest(updateGoalAmountSavedJSON);
        postRespObj respObj = gson.fromJson(response, postRespObj.class);
        return respObj.successful;
    }

    public static boolean updateGoalFinished(String token, String goalID) throws IOException {
        Gson gson = new Gson();
        UpdateGoalFinishedObj updateGoalFinishedObj = new UpdateGoalFinishedObj(token, goalID);
        String updateGoalFinishedJSON = gson.toJson(updateGoalFinishedObj);
        String response = makePostRequest(updateGoalFinishedJSON);
        postRespObj respObj = gson.fromJson(response, postRespObj.class);
        return respObj.successful;
    }

    public static boolean updateGoalActivate(String token, String goalID) throws IOException {
        Gson gson = new Gson();
        ActivateGoalObj activateGoalObj = new ActivateGoalObj(token, goalID);
        String activateGoalJSON = gson.toJson(activateGoalObj);
        String response = makePostRequest(activateGoalJSON);
        postRespObj respObj = gson.fromJson(response, postRespObj.class);
        return respObj.successful;
    }

    public static boolean updateGoalDisable(String token, String goalID) throws IOException {
        Gson gson = new Gson();
        DisableGoalObj disableGoalObj = new DisableGoalObj(token, goalID);
        String disableGoalJSON = gson.toJson(disableGoalObj);
        String response = makePostRequest(disableGoalJSON);
        postRespObj respObj = gson.fromJson(response, postRespObj.class);
        return respObj.successful;
    }

    /*
        Debts
     */

    public static UserDebts retrieveUserDebts(String token) throws IOException {
        Gson gson = new Gson();
        RetrieveDebtsObj retrieveDebtsObj = new RetrieveDebtsObj(token);
        String retrieveDebtsJSON = gson.toJson(retrieveDebtsObj);
        String response = makePostRequest(retrieveDebtsJSON);
        postRespObj respObj = gson.fromJson(response, postRespObj.class);
        String debts = respObj.result;
        return gson.fromJson(debts, UserDebts.class);
    }

    public static Debt createNewDebt(String token, String debtName, Double debtInitial, Double debtCurrent, Double interestRate, Integer compoundFrequency, Double totalPaid) throws IOException {
        Gson gson = new Gson();
        CreateDebtObj createDebtObj = new CreateDebtObj(token, debtName, debtInitial, debtCurrent, interestRate, compoundFrequency, totalPaid);
        String createDebtJSON = gson.toJson(createDebtObj);
        String response = makePostRequest(createDebtJSON);
        postRespObj respObj = gson.fromJson(response, postRespObj.class);
        String user = respObj.result;
        return gson.fromJson(user, Debt.class);
    }

    public static boolean deleteDebt(String token, String debtID) throws IOException {
        Gson gson = new Gson();
        DeleteDebtObj deleteDebtObj = new DeleteDebtObj(token, debtID);
        String deleteDebtJSON = gson.toJson(deleteDebtObj);
        String response = makePostRequest(deleteDebtJSON);
        postRespObj respObj = gson.fromJson(response, postRespObj.class);
        return respObj.successful;
    }

    public static boolean updateDebtName(String token, String debtID, String debtName) throws IOException {
        Gson gson = new Gson();
        UpdateDebtNameObj updateDebtNameObj = new UpdateDebtNameObj(token, debtID, debtName);
        String updateDebtNameJSON = gson.toJson(updateDebtNameObj);
        String response = makePostRequest(updateDebtNameJSON);
        postRespObj respObj = gson.fromJson(response, postRespObj.class);
        return respObj.successful;
    }

    public static boolean updateDebtInitial(String token, String debtID, Double debtInitial) throws IOException {
        Gson gson = new Gson();
        UpdateDebtInitialObj updateDebtInitialObj = new UpdateDebtInitialObj(token, debtID, debtInitial);
        String updateDebtInitialJSON = gson.toJson(updateDebtInitialObj);
        String response = makePostRequest(updateDebtInitialJSON);
        postRespObj respObj = gson.fromJson(response, postRespObj.class);
        return respObj.successful;
    }

    public static boolean updateDebtCurrent(String token, String debtID, Double debtCurrent) throws IOException {
        Gson gson = new Gson();
        UpdateDebtCurrentObj updateDebtCurrentObj = new UpdateDebtCurrentObj(token, debtID, debtCurrent);
        String updateDebtCurrentJSON = gson.toJson(updateDebtCurrentObj);
        String response = makePostRequest(updateDebtCurrentJSON);
        postRespObj respObj = gson.fromJson(response, postRespObj.class);
        return respObj.successful;
    }

    public static boolean updateDebtInterestRate(String token, String debtID, Double debtInterestRate) throws IOException {
        Gson gson = new Gson();
        UpdateDebtInterestRateObj updateDebtInterestRateObj = new UpdateDebtInterestRateObj(token, debtID, debtInterestRate);
        String updateDebtInterestRateJSON = gson.toJson(updateDebtInterestRateObj);
        String response = makePostRequest(updateDebtInterestRateJSON);
        postRespObj respObj = gson.fromJson(response, postRespObj.class);
        return respObj.successful;
    }

    public static boolean updateDebtCompoundFrequency(String token, String debtID, Integer debtCompoundFrequency) throws IOException {
        Gson gson = new Gson();
        UpdateDebtCompoundFrequencyObj updateDebtCompoundFrequencyObj = new UpdateDebtCompoundFrequencyObj(token, debtID, debtCompoundFrequency);
        String updateDebtCompoundFrequencyJSON = gson.toJson(updateDebtCompoundFrequencyObj);
        String response = makePostRequest(updateDebtCompoundFrequencyJSON);
        postRespObj respObj = gson.fromJson(response, postRespObj.class);
        return respObj.successful;
    }

    public static boolean updateDebtTotalPaid(String token, String debtID, Double debtTotalPaid) throws IOException {
        Gson gson = new Gson();
        UpdateDebtTotalPaidObj updateDebtTotalPaidObj = new UpdateDebtTotalPaidObj(token, debtID, debtTotalPaid);
        String updateDebtTotalPaidJSON = gson.toJson(updateDebtTotalPaidObj);
        String response = makePostRequest(updateDebtTotalPaidJSON);
        postRespObj respObj = gson.fromJson(response, postRespObj.class);
        return respObj.successful;
    }

    public static boolean updateDebtFinished(String token, String debtID) throws IOException {
        Gson gson = new Gson();
        UpdateDebtFinishedObj updateDebtFinishedObj = new UpdateDebtFinishedObj(token, debtID);
        String updateDebtFinishedJSON = gson.toJson(updateDebtFinishedObj);
        String response = makePostRequest(updateDebtFinishedJSON);
        postRespObj respObj = gson.fromJson(response, postRespObj.class);
        return respObj.successful;
    }

    public static boolean updateDebtActivate(String token, String debtID) throws IOException {
        Gson gson = new Gson();
        ActivateDebtObj activateDebtObj = new ActivateDebtObj(token, debtID);
        String activateDebtJSON = gson.toJson(activateDebtObj);
        String response = makePostRequest(activateDebtJSON);
        postRespObj respObj = gson.fromJson(response, postRespObj.class);
        return respObj.successful;
    }

    public static boolean updateDebtDisable(String token, String debtID) throws IOException {
        Gson gson = new Gson();
        DisableDebtObj disableDebtObj = new DisableDebtObj(token, debtID);
        String disableDebtJSON = gson.toJson(disableDebtObj);
        String response = makePostRequest(disableDebtJSON);
        postRespObj respObj = gson.fromJson(response, postRespObj.class);
        return respObj.successful;
    }
}
