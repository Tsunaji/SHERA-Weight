package main.java.com.shera.sheraweight.controller;

import main.java.com.shera.sheraweight.model.Province;

public class ProvinceControllerImpl extends TemplateController<Province>{

    public ProvinceControllerImpl() {
        this.API_SERVICE_PATH = cm.SERVER_API + "/scm/province";
    }
    
}
