package de.altwagen.Request;

import de.altwagen.domain.Car;
import de.altwagen.user.Customer;
import de.altwagen.user.Employee;

public class Request {

    private int requestId;
    private Car car;
    private Customer customer;
    private Employee employee;
    private float price;
    private REQUEST_STATUS status;
    private REQUEST_TYPE type;

    public Request(REQUEST_TYPE type, Car car, Customer user) {
        this.type = type;
        this.car = car;
        this.customer = user;
        this.employee = null; // TODO Employee zuweisen
        this.status = REQUEST_STATUS.pending;
    }

    //region Getter and Setter
    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

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

    public REQUEST_STATUS getStatus() {
        return status;
    }

    public void setStatus(REQUEST_STATUS status) {
        this.status = status;
    }

    public REQUEST_TYPE getType() {
        return type;
    }

    public void setType(REQUEST_TYPE type) {
        this.type = type;
    }

    //endregion
}