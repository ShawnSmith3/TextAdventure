package main.models;

public class Weapon {
    private String name;
    private String description;
    private double weight;
    private int damage;

    public Weapon(String name, String description, double weight, int damage){
        
        public void setName(String name){
        this.name = name;
        }

        public void setDescription(String description){
            this.description = description;
        }

        public void setWeight(double weight){
            this.weight = weight;
        }

        public void setDamage(int damage){
            this.damage = damage;
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

        public int getDamage(){
        return damage;
        }

        public String toString() {
        return "{" + getName() + ", " + getDescription() + ", " + getWeight() + getDamage() + "}";
    }
    }
}
