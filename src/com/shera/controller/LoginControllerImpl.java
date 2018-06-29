package com.shera.controller;

import com.google.gson.Gson;
import com.shera.connection.APIConnectionMannager;
import com.shera.model.User;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Response;

public class LoginControllerImpl implements LoginController {

    @Override
    public User authentication(String username, String password) {
        APIConnectionMannager apicm = new APIConnectionMannager();

        String url = "http://10.61.10.109:8080/ldap/authen";
        String json = "{\"username\" : \"" + username + "\","
                + " \"password\" : \"" + password + "\"}";

        Response response = null;
        String result = "";
        User user = null;

        try {
            response = apicm.post(url, json);
            if (response.code() == 200) {
                result = response.body().string();
                Gson gson = new Gson();
                user = gson.fromJson(result, User.class);
            }
        } catch (IOException ex) {
            Logger.getLogger(LoginControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public void testGet() {
        APIConnectionMannager apicm = new APIConnectionMannager();

        String url = "http://10.61.10.109:8080/ldap/random100";

        Response respoonse = null;
        String result = "";

        try {
            respoonse = apicm.get(url);
            result = respoonse.body().string();
        } catch (IOException ex) {
            Logger.getLogger(LoginControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Random: " + result);
    }
}
