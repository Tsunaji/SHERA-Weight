package com.shera.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.shera.connection.APIConnectionMannager;
import com.shera.model.Vehicle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Response;

public class VehicleControllerImpl implements VehicleController {

    APIConnectionMannager apicm = new APIConnectionMannager();
    Gson gson = new Gson();

    @Override
    public boolean registerVehicle(Vehicle vehicle) {
        String url = "http://10.61.10.109:8080/weight/vehicles";
        Response response = null;
        String json = gson.toJson(vehicle);

        try {
            response = apicm.post(url, json);
            if (response.code() == 200) {
                return true;
            } else {
                Logger.getLogger("Register vehicle fail ! " + response.body().toString());
                return false;
            }
        } catch (IOException ex) {
            Logger.getLogger(LoginControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Vehicle getVehicle(int id) {
        String url = "http://10.61.10.109:8080/weight/vehicle/" + id;
        Response response = null;
        String result = "";
        Vehicle vehicle = null;

        try {
            response = apicm.get(url);
            if (response.code() == 200) {
                result = response.body().string();
                vehicle = gson.fromJson(result, Vehicle.class);
            } else {
                Logger.getLogger("Get vehicle fail ! " + response.body().toString());
            }
        } catch (IOException ex) {
            Logger.getLogger(LoginControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vehicle;
    }

    @Override
    public List<Vehicle> getAllVehicle() {
        List<Vehicle> vehicles = new ArrayList<>();
        String url = "http://10.61.10.109:8080/weight/vehicle";
        Response response = null;
        String result = "";

        try {
            response = apicm.get(url);
            if (response.code() == 200) {
                result = response.body().string();
                vehicles = gson.fromJson(result, new TypeToken<List<Vehicle>>() {
                }.getType());
            } else {
                Logger.getLogger("Get all vehicle fail ! " + response.body().toString());
            }
        } catch (IOException ex) {
            Logger.getLogger(LoginControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehicles;
    }

    @Override
    public boolean updateVehicle(Vehicle vehicle, int id) {
        String url = "http://10.61.10.109:8080/weight/vehicle/" + id;
        Response response = null;

        String json = gson.toJson(vehicle);

        try {
            response = apicm.post(url, json);
            if (response.code() == 200) {
                return true;
            } else {
                Logger.getLogger("Update car fail ! " + response.body().toString());
                return false;
            }
        } catch (IOException ex) {
            Logger.getLogger(LoginControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean validateShipment(int id, String shipment) {
        String url = "http://10.61.10.109:8080/weight/vehicle/" + id + "/shipment/" + shipment;

        Response response = null;

        try {
            response = apicm.get(url);
            if (response.code() == 200) {
                return true;
            } else {
                Logger.getLogger("Validate shipment fail ! " + response.body().toString());
                return false;
            }
        } catch (IOException ex) {
            Logger.getLogger(LoginControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
