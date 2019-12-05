package de.altwagen.domain;

public class Car {

    //Variablen erstmal alles public
    int carId;
    float price;
    String constructionYear;
    int drivenKM;
    String brand;
    String model;
    String note;
    Location location;

    public Car(float price, String constructionYear, int drivenKM, String brand, String model, String note, Location location) {
        this.price = price;
        this.constructionYear = constructionYear;
        this.drivenKM = drivenKM;
        this.brand = brand;
        this.model = model;
        this.note = note;
        this.location = location;
    }

    //Methoden erstmal alles public
    //Getter
    public int getCarId(){
        return this.carId;
    };
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

    //setter
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
    public void setModel(String model){
        this.model = model;
    };
    public void setNote(String note){
        this.note = note;
    };
    public void setLocation(Location location){
        this.location = location;
    };
}
