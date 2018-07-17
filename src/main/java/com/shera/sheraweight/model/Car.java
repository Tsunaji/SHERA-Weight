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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductCatagory() {
        return productCatagory;
    }

    public void setProductCatagory(String productCatagory) {
        this.productCatagory = productCatagory;
    }

    public String getTransporterType() {
        return transporterType;
    }

    public void setTransporterType(String transporterType) {
        this.transporterType = transporterType;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getTransporterCompany() {
        return transporterCompany;
    }

    public void setTransporterCompany(String transporterCompany) {
        this.transporterCompany = transporterCompany;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public int getWeighFromDocument() {
        return weighFromDocument;
    }

    public void setWeighFromDocument(int weighFromDocument) {
        this.weighFromDocument = weighFromDocument;
    }

    public String getNotInputWeighReason() {
        return notInputWeighReason;
    }

    public void setNotInputWeighReason(String notInputWeighReason) {
        this.notInputWeighReason = notInputWeighReason;
    }

    public int getWeightIn() {
        return weightIn;
    }

    public void setWeightIn(int weightIn) {
        this.weightIn = weightIn;
    }

    public int getWeightOut() {
        return weightOut;
    }

    public void setWeightOut(int weightOut) {
        this.weightOut = weightOut;
    }

    public int getNetweight() {
        return netweight;
    }

    public void setNetweight(int netweight) {
        this.netweight = netweight;
    }

    public int getStandardWeight() {
        return standardWeight;
    }

    public void setStandardWeight(int standardWeight) {
        this.standardWeight = standardWeight;
    }

    public int getPercentDifWeight() {
        return percentDifWeight;
    }

    public void setPercentDifWeight(int percentDifWeight) {
        this.percentDifWeight = percentDifWeight;
    }

    public int getPalleteWeight() {
        return palleteWeight;
    }

    public void setPalleteWeight(int palleteWeight) {
        this.palleteWeight = palleteWeight;
    }

    public String getLendPalleteNumber() {
        return lendPalleteNumber;
    }

    public void setLendPalleteNumber(String lendPalleteNumber) {
        this.lendPalleteNumber = lendPalleteNumber;
    }

    public boolean isIsSpecialRelease() {
        return isSpecialRelease;
    }

    public void setIsSpecialRelease(boolean isSpecialRelease) {
        this.isSpecialRelease = isSpecialRelease;
    }

    public String getSpecialReleaseReason() {
        return specialReleaseReason;
    }

    public void setSpecialReleaseReason(String specialReleaseReason) {
        this.specialReleaseReason = specialReleaseReason;
    }

    public String getShipment() {
        return shipment;
    }

    public void setShipment(String shipment) {
        this.shipment = shipment;
    }

    public List<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<Status> statuses) {
        this.statuses = statuses;
    }
    
    
}
