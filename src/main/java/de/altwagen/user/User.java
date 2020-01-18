package de.altwagen.user;

import de.altwagen.domain.Address;

public abstract class User {

    protected String firstname;
    protected String lastname;
    protected String eMail;
    protected String password;
    protected Address userAddress;

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

    @Override
    public boolean equals(Object o){

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of User or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof User)) {
            return false;
        }

        // typecast o to User so that we can compare data members
        User u = (User) o;

        // Compare the data members and return accordingly
        return eMail.equals(u.getEMail());
    }

}

