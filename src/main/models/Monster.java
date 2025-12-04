package main.models;

public class Monster{
    private String name;
    private String description;
    private int health;
    private int damage;
    private Item loot;

    public Monster(String name, String description, int health, int damage, Item loot){
        this.name = name;
        this.description = description;
        this.health = health;
        this.damage = damage;
        this.loot = loot;
    }

    public void setName(String monsterName){
        name = monsterName;
    }
    
    public void setDescription(String monsterDescription){
        description = monsterDescription;
    }

    public void setHealth(int monsterHealth){
        health = monsterHealth;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }

    public void setLoot(Item loot){
        this.loot = loot;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public int getHealth(){
        return health;
    }

    public int getDamage(){
        return damage;
    }

    public Item getLoot(){
        return loot;
    }

    public String toString() {
        return "{" + getName() + ", " + getDescription() + ", " + getHealth() + ", " + getDamage() + ", " + getLoot() + "}";
    }
}
