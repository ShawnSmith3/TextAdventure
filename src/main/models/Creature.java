package main.models;

public class Creature{ 
private String name;
private String description;
private int health;

    public Creature(String name, String description, int health){
    this.name = name;
    this.description = description;
    this.health = health;
    }

    public void setName(String creatureName){
        name = creatureName;
    }
    
    public void setDescription(String creatureDescription){
        description = creatureDescription;
    }

    public void setHealth(int creatureHealth){
        health = creatureHealth;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public double getHealth(){
        return health;
    }

    public String toString() {
        return "{" + getName() + ", " + getDescription() + ", " + getHealth() + "}";
    }
}