package de.altwagen.user;

import de.altwagen.domain.Address;

public abstract class User {

    private int userId = -1;
    private String firstname;
    private String lastname;
    private String eMail;
    private String password;
    private Address userAddress;

    public User(String firstname, String lastname, String eMail, String password, Address userAddress) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.eMail = eMail;
        this.password = password;
        this.userAddress = userAddress;
    }

    //region Getter and Setter
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

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

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
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

