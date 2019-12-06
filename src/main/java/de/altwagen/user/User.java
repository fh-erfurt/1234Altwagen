package de.altwagen.user;

import de.altwagen.domain.Address;

public abstract class User {

    //Variablen erstmal alles public
    int userId = -1;
    String firstname;
    String lastname;
    String eMail;
    String password;
    Address userAddress;

    public User(String firstname, String lastname, String eMail, String password, Address userAddress) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.eMail = eMail;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(Address userAddress) {
        this.userAddress = userAddress;
    }
    //endregion

}

