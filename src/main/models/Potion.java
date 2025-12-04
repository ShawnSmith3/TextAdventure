package main.models;

public class Potion extends Item {
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
        return "{" + getName() + ", " + getDescription() + ", " + getWeight() + getHealAmount() + "}";
    }
}
