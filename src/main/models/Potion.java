package main.models;

public class Potion {
    private String name;
    private String description;
    private double weight;
    private int healAmount;
    
    public Potion(String name, String description, double weight, int healAmount){
    this.name = name;
    this.description = description;
    this.weight = weight;
    this.healAmount = healAmount;
    }

    public void setName(String itemName){
        name = itemName;
    }
    
    public void setDescription(String itemDescription){
        description = itemDescription;
    }

    public void setWeight(double itemWeight){
        weight = itemWeight;
    }

    public void setHealAmount(int potionHealAmount){
        healAmount = potionHealAmount;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public double getWeight(){
        return weight;
    }

    public double getHealAmount(){
        return healAmount;
    }

    public String toString() {
        return "{" + getName() + ", " + getDescription() + ", " + getWeight() + getHealAmount() + "}";
    }
}
