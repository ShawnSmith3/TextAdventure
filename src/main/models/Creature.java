package main.models;

import main.Interfaces.Saveable;

public class Creature extends GameEntity implements Saveable { 
    private double health;

    public Creature(String name, String description, double health){
        super(name, description);
        this.health = health;
    }

    public void setHealth(double creatureHealth){
        health = creatureHealth;
    }

    public double getHealth(){
        return health;
    }

    public String toString() {
        return "{" + super.toString() + ", " + getHealth() + "}";
    }
}