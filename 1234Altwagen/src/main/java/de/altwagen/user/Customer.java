package de.altwagen.user;

import de.altwagen.domain.Address;
import de.altwagen.domain.Car;
import de.altwagen.domain.Request;
import de.altwagen.user.User;

public class Customer extends User {

    //Variablen erstmal alles public


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
        return createRequest(car, false);
    }

    /**
     * Erstellt Anfrage zum Kauf eines Autos
     * @param car
     * @return neu erstellter Request
     */
    public Request  requestBuyCar(Car car){
        return createRequest(car, true);
    }

    private Request createRequest(Car car, boolean type){
        Request request = new Request(type, car, this.userId);

        // TODO? Java2: speichere Request in DB (hier oder an anderer Stelle?)

        return request;
    }


}
