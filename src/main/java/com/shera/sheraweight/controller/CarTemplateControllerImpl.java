package main.java.com.shera.sheraweight.controller;

import main.java.com.shera.sheraweight.model.CarTemplate;

public class CarTemplateControllerImpl extends TemplateController<CarTemplate>{

    public CarTemplateControllerImpl() {
        this.API_SERVICE_PATH = cm.SERVER_API + "/scm/carTemplate";
    }
    
}
