package main.java.com.shera.sheraweight.controller;

import com.google.gson.Gson;
import main.java.com.shera.sheraweight.model.LdapUser;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.java.com.shera.sheraweight.util.ConfigManager;
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
    public LdapUser authentication(String username, String password) {
        String url = cm.getServerAPI() + "/ldap/user";

        String json = "{\"username\" : \"" + username + "\","
                + " \"password\" : \"" + password + "\"}";

        LdapUser user = null;

        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                logger.log(Level.SEVERE, response.toString());
            } else {
                user = gson.fromJson(response.body().string(), LdapUser.class);
            }
        } catch (IOException ex) {
            Logger.getLogger(LoginControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
}
