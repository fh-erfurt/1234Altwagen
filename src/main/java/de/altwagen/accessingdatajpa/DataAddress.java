package de.altwagen.accessingdatajpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class DataAddress {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int address_id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String country;
    private String city;
    private String postcode;
    private String street;
    private String houseNumber;

    protected DataAddress(){}

    public DataAddress(int address_id, Timestamp createdAt, Timestamp updatedAt, String country, String city,
                       String postcode, String street, String houseNumber)
    {
        this.address_id = address_id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.country = country;
        this.city = city;
        this.postcode = postcode;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return String.format(
                "Address[address_id='%d', createdAt='%ts', updatedAt='%ts', country='%s', city='%s', postcode='%s', street='%s', houseNumber='%s']",
                address_id, createdAt, updatedAt, country, city, postcode, street, houseNumber);
    }

    public int getAddress_id() {
        return address_id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }
}