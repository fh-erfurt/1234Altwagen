package de.altwagen.domain;

public class Request {

    //Variablen erstmal alles public
    int requestId;
    boolean isSell;
    Car car;
    int customerId;
    int employeeId;
    String status;

    public Request(boolean isSell, Car car, int userId) {
        this.isSell = isSell;
        this.car = car;
        this.customerId = userId;
        this.employeeId = -1; // TODO Employee zuweisen
        this.status = "Anfrage";
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
    public String getStatus(){
        return this.status;
    };
    //Setter
    public void setRequestId(int requestId){
        this.requestId = requestId;
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
    public void setStatus(String status){
        this.status = status;
    };
}
