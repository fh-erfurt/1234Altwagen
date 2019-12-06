package de.altwagen.domain;

public class Location {

    //Class variables all private
    private int locId;
    private Address address;


    //Getter
    public int getLocId(){ return this.locId; };
    public Address getAddress(){
        return this.address;
    };


    //Setter
    public void setLocId(int locId){ this.locId = locId; };
    public void setAddress(Address address){
        this.address = address;
    };


    //eine funktion zum ändern des standortes/zum aktualisieren?
}
