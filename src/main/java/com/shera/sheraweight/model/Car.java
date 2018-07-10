package main.java.com.shera.sheraweight.model;

import java.util.List;

public class Car {

    private String id;
    private String processType;
    private String productType;
    private String productCatagory;
    private String transporterType;
    private String carType;
    private String license;
    private String transporterCompany;
    private String contactName;
    private String company;
    private String phone;
    private String documentNumber;
    private int weighFromDocument;
    private String notInputWeighReason;
    private int weightIn;
    private int weightOut;
    private int netweight;
    private int standardWeight;
    private int percentDifWeight;
    private int palleteWeight;
    private String lendPalleteNumber;
    private boolean isSpecialRelease;
    private String specialReleaseReason;
    private String shipment;
    private List<Status> statuses;

    public Car() {
    }
}
