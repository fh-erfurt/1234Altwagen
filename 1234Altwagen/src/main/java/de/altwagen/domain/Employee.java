package de.altwagen.domain;

import de.altwagen.Request.Request;
import de.altwagen.Request.STATUS;
import de.altwagen.Request.TYPE;

public class Employee extends User{

    //Class variables all private


    //Constructor for Employee because an error occured
    public Employee(int userId,
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

    //Accepts the Request
    public void acceptRequest(Request request){
        if(request.getType() == TYPE.BUY){
            request.setStatus(STATUS.SOLD); //When customer buys, we as the company sell
        }
        else{
            request.setStatus((STATUS.BOUGHT)); //When customer sells, we as the company buy
        }
    }

    //Denies the request
    public void denieRequest(Request request){
        request.setStatus(STATUS.DENIED);
    }

    //deletes a sold car
    public void deleteCar(Car car){
    Controller.deleteCar(car);
    }
}
