package main.java.com.shera.sheraweight.controller;

import main.java.com.shera.sheraweight.model.CarStatus;

public class CarStatusControllerImpl extends TemplateController<CarStatus>{

    public CarStatusControllerImpl() {
        this.API_SERVICE_PATH = cm.SERVER_API + "/scm/carStatus";
    }
    
}
