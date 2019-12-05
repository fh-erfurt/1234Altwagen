package de.altwagen.domain;

public class Location {

    //Class variables all private
    private int locId;
    private Adress adress;


    //Getter
    public int getLocId(){ return this.locId; };
    public Adress getAdress(){
        return this.adress;
    };


    //Setter
    public void setLocId(int locId){ this.locId = locId; };
    public void setadress(Adress adress){
        this.adress = adress;
    };


    //eine funktion zum ändern des standortes/zum aktualisieren?
}
