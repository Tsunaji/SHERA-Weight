package main.java.com.shera.sheraweight.model;

import java.util.Date;

public class CarStatus {

    private String id;
    private String carID;
    private String name;
    private Date timestamp;
    private Date estimateTime;

    public CarStatus() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Date getEstimateTime() {
        return estimateTime;
    }

    public void setEstimateTime(Date estimateTime) {
        this.estimateTime = estimateTime;
    }

    @Override
    public String toString() {
        return "CarStatus{" + "id=" + id + ", carID=" + carID + ", name=" + name + ", timestamp=" + timestamp + ", estimateTime=" + estimateTime + '}';
    }
}
