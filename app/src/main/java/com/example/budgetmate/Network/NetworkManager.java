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
}
