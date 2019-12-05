package de.altwagen.domain;

public class Customer extends User{

    //Class variables all private
    private  int countRequests = 0;

    //Constructor for Customer, because an error occured
    public Customer(int userId,
                    String firstname,
                    String surename,
                    String eMail,
                    String passwort,
                    Adress userAdress) {
        super(userId,
                firstname,
                surename,
                eMail,
                passwort,
                userAdress);
    }


    //Getter
    public int getCountRequests(){ return this.countRequests; }

    //Setter
    public void setCountRequests(int countRequests){
        this.countRequests = countRequests;
    };


    //creates a request to sell the car
    public Request requestSellCar(Car car, int price){
        /*
        if(Controller.listRequests == null){

            ArrayList<Request> listRequests = new ArrayList<request>;
            int requestId = listRequest.size;
        }
        else{

            int requestId = listRequest.size;
        }
        */
        TYPE type = TYPE.SELL;
        // Car car; //no price as we sell and the customer is buying the set price
        Customer customer = new Customer(this.getUserId(),this.);
        Employee employee;
        STATUS status = STATUS.WAITING;
        //float price; //already in the function header

        if(countRequests >= 2){
            Request request = new Request(requestId,type,car,customer,employee,status,price);
            //listRequests.add request;
            countRequests++;
            return request;
        }

        return error;
    }


    //Creates a request to buy a car
    public Request  requestBuyCar(Car car){
        /*
        if(Controller.listRequests == null){

            ArrayList<Request> listRequests = new ArrayList<request>;
            int requestId = listRequest.size;
        }
        else{

            int requestId = listRequest.size;
        }
        */
        TYPE type = TYPE.BUY;
        // Car car; //no price as we sell and the customer is buying the set price
        Customer customer = new Customer(this.getUserId(),this.);
        Employee employee;
        STATUS status = STATUS.WAITING;
        float price = car.getPrice();

        if(countRequests >= 2){
        Request request = new Request(requestId,type,car,customer,employee,status,price);
        //listRequests.add request;
        countRequests++;
        return request;
        }

        return error;
    }


    //cancels a request
    public boolean cancelRequest(Request request){

        if(request!=null) {
            return true;
        }
        else{
            return false;
        }
    }

}
