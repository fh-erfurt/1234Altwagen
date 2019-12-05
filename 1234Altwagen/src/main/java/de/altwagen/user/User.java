package de.altwagen.user;

import de.altwagen.domain.Address;

public abstract class User {

    //Variablen erstmal alles public
    int userId = -1;
    String firstname;
    String lastname;
    String eMail;
    String passwort;
    Address userAddress;

    public User(String firstname, String lastname, String eMail, String passwort, Address userAddress) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.eMail = eMail;
        this.passwort = passwort;
        this.userAddress = userAddress;
    }

    //region Getter and Setter
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public Address getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(Address userAddress) {
        this.userAddress = userAddress;
    }
    //endregion

    public static User getUserById(int userId){
        // TODO Java2: Hole User aus DB
        User user = null;
        return user;
    }
}

