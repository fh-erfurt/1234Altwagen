package de.altwagen.user;

import de.altwagen.Car.Car;
import de.altwagen.Car.CarManager;
import de.altwagen.Car.CarStatus;
import de.altwagen.Request.Request;
import de.altwagen.Request.RequestManager;
import de.altwagen.domain.Address;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

/**
 * This abstracted class defines all fields and methods the customer and employee have.
 */
@Entity
public abstract class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected String firstname;
    protected String lastname;
    protected String eMail;
    protected String password;
    protected Address userAddress;

    public User(String firstname, String lastname, String eMail, String password, Address userAddress) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.eMail = eMail;
        this.password = password;
        this.userAddress = userAddress;
    }

    //region Getter and Setter
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(Address userAddress) {
        this.userAddress = userAddress;
    }
    //endregion

    @Override
    public boolean equals(Object o){

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of User or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof User)) {
            return false;
        }

        // typecast o to User so that we can compare data members
        User u = (User) o;

        // Compare the data members and return accordingly
        return eMail.equals(u.getEMail());
    }

    public ArrayList<Car> listCarsForSale(){
        CarManager carManager = CarManager.getInstance();
        return carManager.listCarsByStatus(CarStatus.FOR_SALE);
    }

    public ArrayList<Request> listMyRequests(){
        RequestManager requestManager = RequestManager.getInstance();
        return requestManager.getRequestsByUser(this);
    }

}

