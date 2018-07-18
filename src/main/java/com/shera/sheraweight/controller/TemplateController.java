package main.java.com.shera.sheraweight.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.java.com.shera.sheraweight.util.ConfigManager;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public abstract class TemplateController<T> {

    Logger logger = Logger.getLogger(this.getClass().getName());

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    ConfigManager cm = new ConfigManager();
    Gson gson = new Gson();

    public static String API_SERVICE_PATH;
    public Class<T> typeOfT;

    public T get(String id) {
        OkHttpClient client = new OkHttpClient();
        String url = API_SERVICE_PATH + id;
        T t = null;

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                logger.log(Level.SEVERE, response.toString());
            } else {
                t = gson.fromJson(response.body().string(), typeOfT);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return t;
    }

    public List<T> getAll() {
        OkHttpClient client = new OkHttpClient();
        List<T> ts = new ArrayList<>();
        String url = API_SERVICE_PATH;

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                logger.log(Level.SEVERE, response.toString());
            } else {
                ts = gson.fromJson(response.body().string(), new TypeToken<List<T>>() {
                }.getType());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return ts;
    }

    public boolean create(T object) {
        OkHttpClient client = new OkHttpClient();
        String url = API_SERVICE_PATH;
        String json = gson.toJson(object);

        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                logger.log(Level.SEVERE, response.toString());
            }
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean update(T object, String id) {
        OkHttpClient client = new OkHttpClient();
        String url = API_SERVICE_PATH + id;
        String json = gson.toJson(object);

        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .put(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                logger.log(Level.SEVERE, response.toString());
            }
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean delete(String id) {
        OkHttpClient client = new OkHttpClient();
        String url = API_SERVICE_PATH + id;

        Request request = new Request.Builder()
                .url(url)
                .delete()
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                logger.log(Level.SEVERE, response.toString());
            } else {
                return true;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
