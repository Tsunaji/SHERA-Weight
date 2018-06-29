package com.shera.controller;

import com.shera.model.Car;
import java.util.List;

public interface CarController {

    boolean registerCar(Car car);

    Car getCar();

    List<Car> getAllCar();

    void updateStatus(int id);

    void updateWeighIn(int id);

    void updateWeighOut(int id);

    boolean validateShipment(int id, String shipment);
}
