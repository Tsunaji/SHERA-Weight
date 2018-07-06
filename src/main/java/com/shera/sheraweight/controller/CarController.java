package main.java.com.shera.sheraweight.controller;

import main.java.com.shera.sheraweight.model.Car;
import java.util.List;

public interface CarController {

    boolean registerCar(Car car);

    Car getCar(int id);

    List<Car> getAllCar();

    boolean updateCar(Car car, int id);

    boolean validateShipment(int id, String shipment);
}
   