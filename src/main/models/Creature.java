package main.models;

import main.Interfaces.Saveable;

public class Creature extends GameEntity implements Saveable { 
    private int health;

    public Creature(String name, String description, int health){
        super(name, description);
        this.health = health;
    }

    public void setHealth(int creatureHealth){
        health = creatureHealth;
    }

    public double getHealth(){
        return health;
    }

    public String toString() {
        return "{" + super.toString() + ", " + getHealth() + "}";
    }
}