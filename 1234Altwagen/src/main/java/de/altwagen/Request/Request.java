package de.altwagen.Request;

import de.altwagen.domain.Car;

public class Request {

    //Variablen erstmal alles public
    private int requestId;
    private Car car;
    private int customerId;
    private int employeeId;
    private float price;
    private STATUS status;
    private TYPE type;

    public Request(TYPE type, Car car, int userId) {
        this.type = type;
        this.car = car;
        this.customerId = userId;
        this.employeeId = -1; // TODO Employee zuweisen
        this.status = STATUS.Waiting;
    }

    //Methoden erstmal alles public
    //Getter
    public int getRequestId(){
        return this.requestId;
    };
    public Car getCar(){
        return this.car;
    };
    public int getCustomerId(){
        return this.customerId;
    };
    public int getEmployeeId(){
        return this.employeeId;
    };
    public STATUS getStatus(){ return this.status; };
    public float getPrice(){ return this.price; };


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
    public void setCustomerId(int customerId){
        this.customerId = customerId;
    };
    public void setEmployeeId(int employeeId){
        this.employeeId = employeeId;
    };
    public void setStatus(STATUS status){
        this.status = status;
    };
    public void setPrice(float price){ this.price = price;
    };
}
