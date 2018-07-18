package main.java.com.shera.sheraweight.controller;

import main.java.com.shera.sheraweight.model.ProcessType;

public class ProcessTypeControllerImpl extends TemplateController<ProcessType>{

    public ProcessTypeControllerImpl() {
        this.API_SERVICE_PATH = cm.SERVER_API + "/scm/processType";
    }
    
}
