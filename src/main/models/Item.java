package main.models;

public class Item extends GameEntity { 
    private double weight;

    public Item(String name, String description, double weight){
        super(name, description);
        this.weight = weight;
    }

    public void setWeight(double itemWeight){
        weight = itemWeight;
    }

    public double getWeight(){
        return weight;
    }

    public String toString() {
        return "{" + getName() + ", " + getDescription() + ", " + getWeight() + "}";
    }
}