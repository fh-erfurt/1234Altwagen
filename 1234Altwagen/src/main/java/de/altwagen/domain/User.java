package de.altwagen.domain;

public class User {

    //Variablen erstmal alles public
    int userId;
    String firstname;
    String surename;
    String eMail;
    String passwort;
    Adress userAdress;

    //Methoden erstmal alles public
    //Getter
    public int getUserId(){ return this.userId; }
    public String getFirstname(){ return this.firstname; }
    public String getSurename(){
        return this.surename;
    }
    public String getEMail(){
        return this.eMail;
    }
    public String getPasswort(){
        return this.passwort;
    }
    public Adress getUserAdress(){
        return this.userAdress;
    }
    //Setter
    public void setUserId(int userId){ this.userId = userId; };
    public void setFirstname(String firstname){ this.firstname = firstname; };
    public void setSurename(String surename){ this.surename = surename; };
    public void seteMail(String eMail){ this.eMail = eMail; };
    public void setPasswort(String passwort){ this.passwort = passwort; };
    public void setUserAdress(Adress userAdress){ this.userAdress = userAdress; };
}

