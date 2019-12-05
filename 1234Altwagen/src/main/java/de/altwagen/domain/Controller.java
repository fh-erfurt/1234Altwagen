package de.altwagen.domain;
import java.util.*;

public class Controller<car, request> {


    /*
    //Class variables all private
    public void createlListCars(){
    Car car;
    //public static Object listRequests;
    ArrayList<Car> listCars = new ArrayList<car>;}

    public void createlListRequests(){
    Request request;
    ArrayList<Request> listRequests = new ArrayList<request>;}
    */

    //registers a new User
    public boolean registerUser(int userId,String firstname,String surename,String eMail,String passwort,Adress userAdress){
        User user  = new User(userId,firstname,surename,eMail,passwort,userAdress);
        if(user!=null) {
            return true;
        }
        else{
            return false;
        }
    }

    /*
    //Deletes User and all of its Values so login is no longer possible and relationships disconnect
    public boolean deleteUser(User user){
        boolean success = false;

        user.userId = null;
        user.firstname = null;
        user.surename= null;
        user.eMail= null;
        user.passwort= null;
        user.userAdress= null;

        return success;
    }*/

    public boolean createCar(int carId, float price, String constructionYear, int drivenKM, String brand, String model, String note, Location location, String status){
        Car car = new Car(carId, price, constructionYear, drivenKM, brand, model, note, location, status);
        if(car!=null) {
            return true;
        }
        else{
            return false;
        }
    }

    /*
    //Deletes Car and all of its Values all relationships disconnect
    public boolean deleteCar(Car car){
        boolean success = false;

        user.userId = null;
        user.firstname = null;
        user.surename= null;
        user.eMail= null;
        user.passwort= null;
        user.userAdress= null;

        return success;
    }*/
}
