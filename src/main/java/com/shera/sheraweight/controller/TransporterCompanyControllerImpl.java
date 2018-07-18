package main.java.com.shera.sheraweight.controller;

import main.java.com.shera.sheraweight.model.TransporterCompany;

public class TransporterCompanyControllerImpl extends TemplateController<TransporterCompany>{

    public TransporterCompanyControllerImpl() {
        this.API_SERVICE_PATH = cm.SERVER_API + "/scm/transporterCompany";
    }
    
}