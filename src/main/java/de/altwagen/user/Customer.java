package de.altwagen.user;

import de.altwagen.domain.Address;
import de.altwagen.domain.Car;
import de.altwagen.Request.Request;
import de.altwagen.Request.TYPE;

public class Customer extends User {

    //Variablen erstmal alles public
    private int requestCount = 0;


    public Customer(String firstname, String lastname, String eMail, String passwort, Address userAddress) {
        super(firstname, lastname, eMail, passwort, userAddress);
    }

    //Methoden erstmal alles public

    /**
     * Erstellt Anfrage zum Verkauf eines Autos
     * @param car
     * @return neu erstellter Request
     */
    public Request requestSellCar(Car car){
        return createRequest(car, TYPE.Sell);
    }

    /**
     * Erstellt Anfrage zum Kauf eines Autos
     * @param car
     * @return neu erstellter Request
     */
    public Request  requestBuyCar(Car car){
        return createRequest(car, TYPE.Buy);
    }

    public boolean cancelRequest(Request request){
        //TODO

        boolean result = false;
        return result;
    }

    private Request createRequest(Car car, TYPE type){
        Request request = new Request(type, car, this);

        // TODO? Java2: speichere Request in DB (hier oder an anderer Stelle?)

        //countRequest++
        if(requestCount <= 2){
            //erstelle Request
        }
        else{
            // ERROR
        }
        return request;
    }


}
