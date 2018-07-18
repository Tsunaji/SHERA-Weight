package main.java.com.shera.sheraweight.controller;

import main.java.com.shera.sheraweight.model.CarType;

public class CarTypeControllerImpl extends TemplateController<CarType>{

    public CarTypeControllerImpl() {
        this.API_SERVICE_PATH = cm.SERVER_API + "/scm/carType";
    }
    
}
