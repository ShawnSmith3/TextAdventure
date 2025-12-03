package main.models;

public class Item{ 
private String name;
private String description;
private double weight;

    public Item(String name, String description, double weight){
    this.name = name;
    this.description = description;
    this.weight = weight;
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

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public double getWeight(){
        return weight;
    }

    public String toString() {
        return "{" + getName() + ", " + getDescription() + ", " + getWeight() + "}";
    }
}