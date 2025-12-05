package main.models;

import main.Interfaces.Interactable;

public class Potion extends Item implements Interactable {
    private int healAmount;
    
    public Potion(String name, String description, double weight, int healAmount){
        super(name, description, weight);
        this.healAmount = healAmount;
    }

    public void setHealAmount(int potionHealAmount){
        healAmount = potionHealAmount;
    }

    public double getHealAmount(){
        return healAmount;
    }

    public String toString() {
        return "{" + super.toString() + ", " + getHealAmount() + "}";
    }

    public void interact(Player player) {
        
    }
    
    public String getData(){
        return "POTION," + getName() + "," + getDescription() + "," + getWeight() + "," + getHealAmount();   
    }

}
