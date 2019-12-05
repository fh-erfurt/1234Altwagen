package de.altwagen.domain;

public class Car {

    //Class variables all private
    private int carId;
    private float price;
    private String constructionYear;
    private int drivenKM;
    private String brand;
    private String model;
    private String note;
    private Location location;
    private String status;

    //Constructor for Car
    public Car(int carId,
               float price,
               String constructionYear,
               int drivenKM, String brand,
               String model, String note,
               Location location,
               String status) {
    }


    //Getter
    public int getCarId(){ return this.carId; };
    public float getPrice(){
        return this.price;
    };
    public String getConstructionYear(){
        return this.constructionYear;
    };
    public int getDrivenKM(){
        return this.drivenKM;
    };
    public String getBrand(){
        return this.brand;
    };
    public String getModel(){
        return this.model;
    };
    public String getNote(){
        return this.note;
    };
    public Location getLocation(){
        return this.location;
    };
    public String getStatus(){
        return this.status;
    };


    //Setter
    public void setCarId(int carId){
      this.carId = carId;
    };
    public void setPrice(float price){
        this.price = price;
    };
    public void setConstructionYear(String constructionYear){
        this.constructionYear = constructionYear;
    };
    public void setDrivenKM(int drivenKM){
        this.drivenKM = drivenKM;
    };
    public void setBrand(String brand){
        this.brand = brand;
    };
    public void setModel(String model){ this.model = model; };
    public void setNote(String note){
        this.note = note;
    };
    public void setLocation(Location location){
        this.location = location;
    };
    public void setStatus(String status){
        this.status = status;
    };

}
