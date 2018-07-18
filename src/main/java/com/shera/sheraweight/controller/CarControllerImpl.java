package main.java.com.shera.sheraweight.controller;

import main.java.com.shera.sheraweight.model.Car;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CarControllerImpl extends TemplateController<Car> {

    Logger thisLogger = Logger.getLogger(CarControllerImpl.class.getName());

    public CarControllerImpl() {
        this.API_SERVICE_PATH = cm.SERVER_API + "/scm/car";
    }

    public boolean updateShipmentStatus(Car object) {
        OkHttpClient client = new OkHttpClient();
        String url = API_SERVICE_PATH + object.getId() + "/shipment/" + object.getShipment();
        String json = gson.toJson(object);

        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .put(body)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                thisLogger.log(Level.SEVERE, response.toString());
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(CarControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean validateShipment(Car object) {
        OkHttpClient client = new OkHttpClient();
        String url = API_SERVICE_PATH + object.getId() + "/shipment/" + object.getShipment();

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                thisLogger.log(Level.SEVERE, response.toString());
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(CarControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
