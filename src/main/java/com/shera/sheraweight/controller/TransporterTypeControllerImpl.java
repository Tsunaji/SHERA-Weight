package main.java.com.shera.sheraweight.controller;

import main.java.com.shera.sheraweight.model.TransporterType;

public class TransporterTypeControllerImpl extends TemplateController<TransporterType>{

    public TransporterTypeControllerImpl() {
        this.API_SERVICE_PATH = cm.SERVER_API + "/scm/transporterType";
    }
    
}
