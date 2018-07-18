package main.java.com.shera.sheraweight.controller;

import main.java.com.shera.sheraweight.model.Incoterm;

public class IncotermControllerImpl extends TemplateController<Incoterm>{

    public IncotermControllerImpl() {
        this.API_SERVICE_PATH = cm.SERVER_API + "/scm/incoterm";
    }
    
}
