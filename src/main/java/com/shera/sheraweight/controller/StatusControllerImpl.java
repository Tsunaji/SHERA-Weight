package main.java.com.shera.sheraweight.controller;

import main.java.com.shera.sheraweight.model.Status;

public class StatusControllerImpl extends TemplateController<Status>{

    public StatusControllerImpl() {
        this.API_SERVICE_PATH = cm.SERVER_API + "/scm/status";
    }
    
}
