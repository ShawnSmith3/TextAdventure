package main.models;

import main.Interfaces.Interactable;

public class Key extends Item implements Interactable {
    private int keyID;

    public Key(String name, String description, double weight, int keyID) {
        super(name, description, weight);
        this.keyID = keyID;
    }

    public void setKeyID(int keyID) {
        this.keyID = keyID; 
    }

    public int getKeyID() {
        return keyID;
    }

    public String toString() {
        return "{" + super.toString() + ", " + getKeyID() + "}";
    }

    public void interact(Player player) {
        
    }
}