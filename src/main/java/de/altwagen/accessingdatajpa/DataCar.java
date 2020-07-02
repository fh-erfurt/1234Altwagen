package de.altwagen.accessingdatajpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class DataCar {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int car_id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String chassisNumber;
    private int constructionYear;
    private int drivenKM;
    private float price;
    private String brand;
    private String model;
    private String note;
    private String status;
    private int location_location_id;

    protected DataCar() {}

    public DataCar(int car_id, Timestamp createdAt, Timestamp updatedAt, String chassisNumber, int constructionYear,
               int drivenKM, float price, String brand, String model, String note,
               String status, int location_location_id)
    {
        this.car_id = car_id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.chassisNumber = chassisNumber;
        this.constructionYear = constructionYear;
        this.drivenKM = drivenKM;
        this.price = price;
        this.brand = brand;
        this.model = model;
        this.note = note;
        this.status = status;
        this.location_location_id = location_location_id;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[car_id=%d, createdAt='%ts', updatedAt='%ts', chassisNumber='%s', constructionYear='%d', drivenKM='%d', price='%f', brand='%s', model='%s', note='%s', status='%s', location_location_id='%d']",
                car_id, createdAt, updatedAt, chassisNumber, constructionYear, drivenKM, price, brand, model, note, status, location_location_id);
    }

    public int getCar_id() {
        return car_id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public int getConstructionYear() {
        return constructionYear;
    }

    public int getDrivenKM() {
        return drivenKM;
    }

    public float getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getNote() {
        return note;
    }

    public String  getStatus () {
        return status;
    }

    public int getLocation_location_id() {
        return location_location_id;
    }
}