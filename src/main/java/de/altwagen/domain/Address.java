package de.altwagen.domain;

/**
 * This class specifies a postal address
 */
public class Address {

    private String country;
    private String city;
    private String postcode;
    private String street;
    private String houseNumber;

    public Address(String country, String city, String postcode, String street, String houseNumber) {
        this.country = country;
        this.city = city;
        this.postcode = postcode;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    //region Getter and Setter
    //Getter
    public String getCountry(){
        return this.country;
    }
    public String getCity() {
        return this.city;
    }
    public String getPostcode() {
        return this.postcode;
    }
    public String getStreet(){
        return this.street;
    }
    public String getHouseNumber(){
        return this.houseNumber;
    }

    //Setter
    public void setCountry(String country){
        this.country = country;
    }
    public void setCity(String city){
        this.city = city;
    }
    public void setPostcode(String postcode){
        this.postcode = postcode;
    }
    public void setStreet(String street){
        this.street = street;
    }
    public void setHouseNumber(String houseNumber){
        this.houseNumber = houseNumber;
    }
    //endregion

    @Override
    public boolean equals(Object o){

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Address or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Address)) {
            return false;
        }

        // typecast o to Address so that we can compare data members
        Address a = (Address) o;

        // Compare the data members and return accordingly
        return country.equals(a.getCountry()) &&
                city.equals(a.getCity()) &&
                postcode.equals((a.getPostcode())) &&
                street.equals(a.getStreet()) &&
                houseNumber.equals(a.getHouseNumber());
    }
}
