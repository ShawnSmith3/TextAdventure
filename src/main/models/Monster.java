package main.models;

public class Monster extends Creature{
    private int damage;
    private Item loot;

    public Monster(String name, String description, int health, int damage, Item loot){
        super(name, description, health);
        this.damage = damage;
        this.loot = loot;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }

    public void setLoot(Item loot){
        this.loot = loot;
    }

    public int getDamage(){
        return damage;
    }

    public Item getLoot(){
        return loot;
    }

    public String toString() {
        return "{" + super.toString() + ", " + getDamage() + ", " + getLoot() + "}";
    }

    public String getData(){
        return "MONSTER," + getName() + "," + getDescription() + "," + getHealth() + "," + getDamage();   
    }
}
