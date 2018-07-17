package main.java.com.shera.sheraweight.controller;

import com.google.gson.Gson;
import java.util.List;
import main.java.com.shera.sheraweight.util.ConfigManager;
import okhttp3.MediaType;

public abstract class TemplateController<T> {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    ConfigManager cm = new ConfigManager();
    Gson gson = new Gson();

    public abstract T get(String id);

    public abstract List<T> getAll();

    public abstract boolean create(T object);

    public abstract boolean update(T object);

    public abstract boolean delete(String id);
}
