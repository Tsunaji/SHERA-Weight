package main.java.com.shera.sheraweight.controller;

import main.java.com.shera.sheraweight.model.Product;

public class ProductControllerImpl extends TemplateController<Product>{

    public ProductControllerImpl() {
        this.API_SERVICE_PATH = cm.SERVER_API + "/scm/product";
    }
    
}
