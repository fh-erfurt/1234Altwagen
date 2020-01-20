package de.altwagen.Car;

import de.altwagen.domain.Location;

public class Car {

    //Class variables all private
    private String chassisNumber;
    private String constructionYear;
    private int drivenKM;
    private float price;
    private String brand;
    private String model;
    private String note;
    private Location location;
    private CarStatus status;

    //Constructor for Car
    public Car(String chassisNumber, String constructionYear, int drivenKM, String brand, String model, String note, Location location, CarStatus status) {
        this.chassisNumber = chassisNumber;
        this.constructionYear = constructionYear;
        this.drivenKM = drivenKM;
        this.brand = brand;
        this.model = model;
        this.note = note;
        this.location = location;
        this.status = status;
    }

    //region Getter and Setter
    //Getter
    public String getChassisNumber(){ return this.chassisNumber; }
    public String getConstructionYear(){
        return this.constructionYear;
    }
    public int getDrivenKM(){
        return this.drivenKM;
    }
    public float getPrice(){
        return this.price;
    }
    public String getBrand(){
        return this.brand;
    }
    public String getModel(){
        return this.model;
    }
    public String getNote(){
        return this.note;
    }
    public Location getLocation(){
        return this.location;
    }
    public CarStatus getStatus(){
        return this.status;
    }


    //Setter
    public void setChassisNumber(String chassisNumber){
      this.chassisNumber = chassisNumber;
    }
    public void setConstructionYear(String constructionYear){
        this.constructionYear = constructionYear;
    }
    public void setDrivenKM(int drivenKM){
        this.drivenKM = drivenKM;
    }
    public void setPrice(float price){
        this.price = price;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public void setModel(String model){ this.model = model; }
    public void setNote(String note){
        this.note = note;
    }
    public void setLocation(Location location){
        this.location = location;
    }
    public void setStatus(CarStatus status){
        this.status = status;
    }
    //endregion

    @Override
    public boolean equals(Object o){

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Car or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Car)) {
            return false;
        }

        // typecast o to Car so that we can compare data members
        Car c = (Car) o;

        // Compare the data members and return accordingly
        return chassisNumber.equals(c.getChassisNumber());
    }

}
