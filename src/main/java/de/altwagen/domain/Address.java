package de.altwagen.domain;

public class Address {

    private int addressId = -1;
    private String country;
    private String city;
    private String postcode;
    private String street;
    private String houseNumber;

	public Address(String country, String city, String postcode, String street, String houseNumber) {
        this(-1, country, city, postcode, street, houseNumber);
    }

    public Address(int addressId, String country, String city, String postcode, String street, String houseNumber) {
	    this.addressId = addressId;
        this.country = country;
        this.city = city;
        this.postcode = postcode;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    //region Getter and Setter
    //Getter
    public int getAddressId(){
        return this.addressId;
    };
    public String getCountry(){
        return this.country;
    };
    public String getCity() {
        return this.city;
    }
    public String getPostcode() {
        return this.postcode;
    }
    public String getStreet(){
        return this.street;
    };
    public String getHouseNumber(){
        return this.houseNumber;
    };

    //Setter
    public void setAddressId(int adrId){
        this.addressId = adrId;
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
    //endregion
}
