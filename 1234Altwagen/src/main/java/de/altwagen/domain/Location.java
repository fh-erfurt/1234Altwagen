package de.altwagen.domain;

public class Location {

    //Variablen erstmal alles public
    int locId;
    Adress adress;

    //Methoden erstmal alles public
    //Getter
    public int getLocId(){
      return this.locId;
    };
    public Adress getAdress(){
        return this.adress;
    };
    //Setter
    public void setLocId(int locId){
      this.locId = locId;
    };
    public void setadress(Adress adress){
        this.adress = adress;
    };
}
