package com.shera.service;

import com.google.gson.Gson;
import com.shera.connection.APIConnectionMannager;
import com.shera.model.User;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginServiceImpl implements LoginService {

    @Override
    public User authentication(String username, String password) {
        APIConnectionMannager apicm = new APIConnectionMannager();

        String url = "http://10.61.10.109:8080/ldap/user";
        String json = "{\"username\" : \"" + username + "\","
                + " \"password\" : \"" + password + "\"}";

        String response = null;

        try {
            response = apicm.post(url, json);
        } catch (IOException ex) {
            Logger.getLogger(LoginServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        Gson gson = new Gson();
        User user = gson.fromJson(response, User.class);

        return user;
    }

    public void testGet() {
        APIConnectionMannager apicm = new APIConnectionMannager();

        String url = "http://10.61.10.109:8080/ldap/random100";

        String respoonse = null;

        try {
            respoonse = apicm.get(url);
        } catch (IOException ex) {
            Logger.getLogger(LoginServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Random: " + respoonse);
    }
}
