package main.java.com.shera.sheraweight.controller;

import com.google.gson.reflect.TypeToken;
import main.java.com.shera.sheraweight.model.Car;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CarControllerImpl extends TemplateController<Car> {

    Logger logger = Logger.getLogger(CarControllerImpl.class.getName());

    @Override
    public Car get(String id) {
        OkHttpClient client = new OkHttpClient();
        String url = cm.getServerAPI() + "/weight/car/" + id;
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
    public List<Car> getAll() {
        OkHttpClient client = new OkHttpClient();
        List<Car> cars = new ArrayList<>();
        String url = cm.getServerAPI() + "/weight/cars";

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
    public boolean create(Car object) {
        OkHttpClient client = new OkHttpClient();
        String url = cm.getServerAPI() + "/weight/car";
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
            Logger.getLogger(LoginControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Car object) {
        OkHttpClient client = new OkHttpClient();
        String url = cm.getServerAPI() + "/weight/car/" + object.getId();
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
            Logger.getLogger(LoginControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        OkHttpClient client = new OkHttpClient();
        String url = cm.getServerAPI() + "/weight/car/" + id;

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
            Logger.getLogger(CarControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateShipmentStatus(Car object) {
        OkHttpClient client = new OkHttpClient();
        String url = cm.getServerAPI() + "/weight/car/" + object.getId() + "/shipment/" + object.getShipment();
        String json = gson.toJson(object);

        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .put(body)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                logger.log(Level.SEVERE, response.toString());
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(CarControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean validateShipment(Car object) {
        OkHttpClient client = new OkHttpClient();
        String url = cm.getServerAPI() + "/weight/car/" + object.getId() + "/shipment/" + object.getShipment();

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                logger.log(Level.SEVERE, response.toString());
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(CarControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
