package de.altwagen.domain;

public class Request<bool> {

    //Variablen erstmal alles public
    int requestId;
    bool type;
    Car car;
    Customer customer;
    Employee employee;
    String status;

    //Methoden erstmal alles public
    //Getter
    public int getRequestId(){
        return this.requestId;
    };
    public bool getType(){
        return this.type;
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
    public String getStatus(){
        return this.status;
    };
    //Setter
    public void setRequestId(int requestId){
        this.requestId = requestId;
    };
    public void setType(bool type){
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
    public void setStatus(String status){
        this.status = status;
    };
}
