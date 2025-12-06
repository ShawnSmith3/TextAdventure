package main.models;

public class Weapon extends Item {
    private int damage;

    public Weapon(String name, String description, double weight, int damage) {
        super(name, description, weight);
        this.damage = damage;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }

    public int getDamage(){
        return damage;
    }

    public String toString() {
        return "{" + super.toString() + ", " + getDamage() + "}";
    }

    public void interact(Player player) {
        player.setDamage(player.getDamage() + getDamage());
        System.out.println("You gained " + getDamage() + " attack damage!");
    }

    public String getData(){
        return "WEAPON," + getName() + "," + getDescription() + "," + getWeight() + "," + getDamage();   
    }
}
