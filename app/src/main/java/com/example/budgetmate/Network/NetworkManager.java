package com.example.budgetmate.Network;

import com.example.budgetmate.Models.User;
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

    public static User retrieveUser(String token) throws IOException {
        Gson gson = new Gson();
        RetrieveUserObj retrieveUserObj = new RetrieveUserObj(token);
        String retrieveUserJSON = gson.toJson(retrieveUserObj);
        String response = makePostRequest(retrieveUserJSON);
        postRespObj respObj = gson.fromJson(response, postRespObj.class);
        String user = respObj.result;
        return gson.fromJson(user, User.class);
    }
}
