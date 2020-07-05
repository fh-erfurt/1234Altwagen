package de.altwagen.Request;

import de.altwagen.Car.Car;
import de.altwagen.user.Customer;
import de.altwagen.user.Employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This class defines a Request, which is created by a user to buy or sell a car from 1234Altwagen
 */
@Entity
public class Request {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Car car;
    private Customer customer;
    private Employee employee;
    private float price;
    private RequestStatus status;
    private RequestType type;

    public Request(RequestType type, Car car, Customer customer, float price) {
        this.type = type;
        this.car = car;
        this.customer = customer;
        this.price = price;
        this.employee = null;
        this.status = RequestStatus.PENDING;
    }

    //region Getter and Setter
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public RequestType getType() {
        return type;
    }

    public void setType(RequestType type) {
        this.type = type;
    }

    //endregion
}
