package edu.ucalgary.oop;

public class Location {
    private String name;
    private String address;
    private DisasterVictim[] occupants;
    private Supply[] supplies;
    private int occupantCount;
    private int supplyCount;

    public Location(String name, String address) {
        this.name = name;
        this.address = address;
        this.occupants = new DisasterVictim[100]; //Assuming a maximum of 100 occupants
        this.supplies = new Supply[100]; //Assuming a maximum of 100 supplies
        this.occupantCount = 0;
        this.supplyCount = 0;
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

    public DisasterVictim[] getOccupants() {
        DisasterVictim[] result = new DisasterVictim[occupantCount];
        System.arraycopy(occupants, 0, result, 0, occupantCount);
        return result;
    }

    public void setOccupants(DisasterVictim[] newOccupants) {
        this.occupants = new DisasterVictim[100];
        this.occupantCount = newOccupants.length;
        System.arraycopy(newOccupants, 0, this.occupants, 0, newOccupants.length);
    }

    public void addOccupant(DisasterVictim occupant) {
        if (occupantCount < occupants.length) {
            occupants[occupantCount++] = occupant;
        }
    }

    public void removeOccupant(DisasterVictim occupant) {
        for (int i = 0; i < occupantCount; i++) {
            if (occupants[i].equals(occupant)) {
                // Shift all elements after the removed occupant to the left
                System.arraycopy(occupants, i + 1, occupants, i, occupantCount - i - 1);
                occupantCount--;
                break;
            }
        }
    }

    public Supply[] getSupplies() {
        Supply[] result = new Supply[supplyCount];
        System.arraycopy(supplies, 0, result, 0, supplyCount);
        return result;
    }

    public void setSupplies(Supply[] newSupplies) {
        this.supplies = new Supply[100];
        this.supplyCount = newSupplies.length;
        System.arraycopy(newSupplies, 0, this.supplies, 0, newSupplies.length);
    }

    public void addSupply(Supply supply) {
        if (supplyCount < supplies.length) {
            supplies[supplyCount++] = supply;
        }
    }

    public void removeSupply(Supply supply) {
        for (int i = 0; i < supplyCount; i++) {
            if (supplies[i].equals(supply)) {
                // Shift all elements after the removed supply to the left
                System.arraycopy(supplies, i + 1, supplies, i, supplyCount - i - 1);
                supplyCount--;
                break;
            }
        }
    }
}