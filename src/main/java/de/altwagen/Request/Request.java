package de.altwagen.Request;

import de.altwagen.domain.Car;
import de.altwagen.user.Customer;
import de.altwagen.user.Employee;

public class Request {

    //Variablen erstmal alles public
    private int requestId;
    private Car car;
    private Customer customer
    private Employee employee;
    private float price;
    private REQUEST_STATUS REQUESTStatus;
    private TYPE type;

    public Request(TYPE type, Car car, Customer user) {
        this.type = type;
        this.car = car;
        this.customer = user;
        this.employee = null; // TODO Employee zuweisen
        this.REQUESTStatus = REQUEST_STATUS.unassigned;
    }

    //Methoden erstmal alles public
    //Getter
    public int getRequestId(){
        return this.requestId;
    };
    public Car getCar(){
        return this.car;
    };
    public Customer getCustomer(){
        return this.customer;
    };
    public Employee getEmployee(){
        return this.employee;
    };
    public REQUEST_STATUS getREQUESTStatus(){ return this.REQUESTStatus; };
    public float getPrice(){ return this.price; };
    public TYPE getType(){ return this.type;};


    //Setter
    public void setRequestId(int requestId){
        this.requestId = requestId;
    };

    public void setType(TYPE type){
        this.type = type;
    };

    public void setCar(Car car){
        this.car = car;
    };
    public void setCustomer(Customer customer){
        this.customer = customer;
    };
    public void setEmployee(Employee employee){
        this.employee = employee;
    };
    public void setREQUESTStatus(REQUEST_STATUS REQUESTStatus){
        this.REQUESTStatus = REQUESTStatus;
    };
    public void setPrice(float price){ this.price = price;
    };
}
