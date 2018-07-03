package main.java.shera.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import main.java.shera.model.Vehicle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.java.shera.util.ConfigManager;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class VehicleControllerImpl implements VehicleController {

    Logger logger = Logger.getLogger(VehicleControllerImpl.class.getName());

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();
    ConfigManager cm = new ConfigManager();
    Gson gson = new Gson();

    @Override
    public boolean registerVehicle(Vehicle vehicle) {
        String url = cm.getHostServerAPI() + "/weight/vehicles";
        String json = gson.toJson(vehicle);

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
    public Vehicle getVehicle(int id) {
        String url = cm.getHostServerAPI() + "/weight/vehicle/" + id;
        Vehicle vehicle = null;

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                logger.log(Level.SEVERE, response.toString());
            } else {
                vehicle = gson.fromJson(response.body().string(), Vehicle.class);
            }
        } catch (IOException ex) {
            Logger.getLogger(VehicleControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vehicle;
    }

    @Override
    public List<Vehicle> getAllVehicle() {
        List<Vehicle> vehicles = new ArrayList<>();
        String url = cm.getHostServerAPI() + "/weight/vehicle";

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                logger.log(Level.SEVERE, response.toString());
            } else {
                vehicles = gson.fromJson(response.body().string(), new TypeToken<List<Vehicle>>() {
                }.getType());
            }
        } catch (IOException ex) {
            Logger.getLogger(VehicleControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehicles;
    }

    @Override
    public boolean updateVehicle(Vehicle vehicle, int id) {
        String url = cm.getHostServerAPI() + "/weight/vehicle/" + id;
        String json = gson.toJson(vehicle);

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
    public boolean validateShipment(int id, String shipment) {
        String url = cm.getHostServerAPI() + "/weight/vehicle/" + id + "/shipment/" + shipment;

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
            Logger.getLogger(VehicleControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
