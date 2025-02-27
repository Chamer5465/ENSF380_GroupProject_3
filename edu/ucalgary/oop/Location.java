package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private String name;
    private String address;
    private List<DisasterVictim> occupants;
    private List<Supply> supplies;

    public Location(String name, String address) {
        this.name = name;
        this.address = address;
        this.occupants = new ArrayList<DisasterVictim>();
        this.supplies = new ArrayList<Supply>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<DisasterVictim> getOccupants() {
        return this.occupants;
    }

    public void setOccupants(List<DisasterVictim> newOccupants) {
        this.occupants = new ArrayList<DisasterVictim>(newOccupants);
    }

    public void addOccupant(DisasterVictim occupant) {
        this.occupants.add(occupant);
    }

    public void removeOccupant(DisasterVictim occupant) {
        this.occupants.remove(occupant);
    }

    public List<Supply> getSupplies() {
        return this.supplies;
    }

    public void setSupplies(List<Supply> newSupplies) {
        this.supplies = new ArrayList<Supply>(newSupplies);
    }

    public void addSupply(Supply supply) {
        this.supplies.add(supply);
    }

    public void removeSupply(Supply supply) {
        this.supplies.remove(supply);
    }
}