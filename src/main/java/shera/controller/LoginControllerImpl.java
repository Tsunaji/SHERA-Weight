package main.java.shera.controller;

import com.google.gson.Gson;
import main.java.shera.model.User;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.java.shera.util.ConfigManager;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginControllerImpl implements LoginController {

    Logger logger = Logger.getLogger(LoginControllerImpl.class.getName());

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();
    ConfigManager cm = new ConfigManager();
    Gson gson = new Gson();

    @Override
    public User authentication(String username, String password) {
        String url = cm.getHostServerAPI() + "/ldap/user";

        String json = "{\"username\" : \"" + username + "\","
                + " \"password\" : \"" + password + "\"}";

        User user = null;

        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                logger.log(Level.SEVERE, response.toString());
            } else {
                user = gson.fromJson(response.body().string(), User.class);
            }
        } catch (IOException ex) {
            Logger.getLogger(LoginControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
}
