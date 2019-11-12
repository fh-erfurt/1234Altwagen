package de.altwagen.domain;

public class Adress {

    //Variablen erstmal alles public
    int adrid;
    String country;
    String city;
    String postcode;
    String street;
    String houseNumber;

    //Methoden erstmal alles public
    //Getter
    public int getAdrid(){
        return this.adrid;
    };
    public String getCountry(){
        return this.country;
    };
    public String getCity(){
        return this.city;
    };
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
