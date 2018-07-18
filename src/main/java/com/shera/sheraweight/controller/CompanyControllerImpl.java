package main.java.com.shera.sheraweight.controller;

import main.java.com.shera.sheraweight.model.Company;

public class CompanyControllerImpl extends TemplateController<Company>{

    public CompanyControllerImpl() {
        this.API_SERVICE_PATH = cm.SERVER_API + "/scm/company";
    }
    
}
