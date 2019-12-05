package de.altwagen.domain;

public class Adress {

    //Class variables all private
    private int adrid;
    private  String country;
    private  String city;
    private  String postcode;
    private  String street;
    private  String houseNumber;


    //Getter
    public int getAdrid(){ return this.adrid; };
    public String getCountry(){
        return this.country;
    };
    public String getCity(){ return this.city; };
    public String getPostCode(){
        return this.postcode;
    };
    public String getStreet(){
        return this.street;
    };
    public String getHouseNumber(){
        return this.houseNumber;
    };


    //Setter
    public void setAdrid(int adrId){
        this.adrid = adrId;
    };
    public void setCountry(String country){
        this.country = country;
    };
    public void setCity(String city){
        this.city = city;
    };
    public void setPostcode(String postcode){
        this.postcode = postcode;
    };
    public void setStreet(String street){
        this.street = street;
    };
    public void setHouseNumber(String houseNumber){
        this.houseNumber = houseNumber;
    };

}
