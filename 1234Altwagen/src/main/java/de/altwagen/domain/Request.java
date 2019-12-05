package de.altwagen.domain;

enum TYPE
{
    SELL, BUY;
}

enum STATUS
{
    WAITING, BOUGHT, SOLD, DENIED;
}

public class Request<bool> {

    //Class variables all private
    private int requestId;
    private TYPE type;
    private Car car;
    private Customer customer;
    private Employee employee;
    private STATUS status;
    private float price;



    //Constructor for Request
    public Request(int requestId,
            TYPE type,
            Car car,
            Customer customer,
            Employee employee,
            STATUS status,
                   float price){}


    //Getter
    public int getRequestId(){ return this.requestId; };
    public TYPE getType(){
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
    public void setCustomer(Customer customer){
        this.customer = customer;
    };
    public void setEmployee(Employee employee){
        this.employee = employee;
    };
    public void setStatus(STATUS status){
        this.status = status;
    };
    public void setPrice(float price){ this.price = price;
    };
}
