package main.java.com.shera.sheraweight.controller;

import main.java.com.shera.sheraweight.model.Factory;

public class FactoryControllerImpl extends TemplateController<Factory>{

    public FactoryControllerImpl() {
        this.API_SERVICE_PATH = cm.SERVER_API + "/scm/factory";
    }
    
}
