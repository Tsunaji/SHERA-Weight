package main.java.com.shera.sheraweight.controller;

import main.java.com.shera.sheraweight.model.ProductType;

public class ProductTypeControllerImpl extends TemplateController<ProductType>{

    public ProductTypeControllerImpl() {
        this.API_SERVICE_PATH = cm.SERVER_API + "/scm/productType";
    }
    
}
