package main.java.com.shera.sheraweight.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import main.java.com.shera.sheraweight.model.Car;
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

public class CarControllerImpl implements CarController {

    Logger logger = Logger.getLogger(CarControllerImpl.class.getName());

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();
    ConfigManager cm = new ConfigManager();
    Gson gson = new Gson();

    @Override
    public boolean registerCar(Car car) {
        String url = cm.getHostServerAPI() + "/weight/car";
        String json = gson.toJson(car);

        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                logger.log(Level.SEVERE, response.toString());
                return false;
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(LoginControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Car getCar(int id) {
        String url = cm.getHostServerAPI() + "/weight/car/" + id;
        Car car = null;

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                logger.log(Level.SEVERE, response.toString());
            } else {
                car = gson.fromJson(response.body().string(), Car.class);
            }
        } catch (IOException ex) {
            Logger.getLogger(CarControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return car;
    }

    @Override
    public List<Car> getAllCar() {
        List<Car> cars = new ArrayList<>();
        String url = cm.getHostServerAPI() + "/weight/cars";

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                logger.log(Level.SEVERE, response.toString());
            } else {
                cars = gson.fromJson(response.body().string(), new TypeToken<List<Car>>() {
                }.getType());
            }
        } catch (IOException ex) {
            Logger.getLogger(CarControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cars;
    }

    @Override
    public boolean updateCar(Car car, int id) {
        String url = cm.getHostServerAPI() + "/weight/car/" + id;
        String json = gson.toJson(car);

        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .put(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                logger.log(Level.SEVERE, response.toString());
                return false;
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(LoginControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean validateShipment(int id, String shipment) {
        String url = cm.getHostServerAPI() + "/weight/car/" + id + "/shipment/" + shipment;

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                logger.log(Level.SEVERE, response.toString());
                return false;
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(CarControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
