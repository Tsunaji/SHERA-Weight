package main.java.com.shera.sheraweight.controller;

import main.java.com.shera.sheraweight.model.Vehicle;
import java.util.List;

public interface VehicleController {

    boolean registerVehicle(Vehicle vehicle);

    Vehicle getVehicle(int id);

    List<Vehicle> getAllVehicle();

    boolean updateVehicle(Vehicle vehicle, int id);

    boolean validateShipment(int id, String shipment);
}
