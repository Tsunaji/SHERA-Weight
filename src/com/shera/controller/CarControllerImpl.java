/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shera.controller;

import com.shera.connection.APIConnectionMannager;
import com.shera.model.Car;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jirasak_ka
 */
public class CarControllerImpl implements CarController {

    @Override
    public boolean registerCar(Car car) {
        APIConnectionMannager apicm = new APIConnectionMannager();

        String url = "http://10.61.10.109:8080/weight/cars";
        String json = "";
        String response = null;

//        try {
//            response = apicm.post(url, json);
//            if(response){
//                
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(LoginControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return false;
    }

    @Override
    public Car getCar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Car> getAllCar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateStatus(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateWeighIn(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateWeighOut(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validateShipment(int id, String shipment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
