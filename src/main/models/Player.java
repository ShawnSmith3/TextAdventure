package main.models;

import java.util.ArrayList;

import main.Interfaces.Interactable;

public class Player extends Creature implements Interactable {
    private ArrayList<Item> inventory;
    private int location;
    private int damage;
    private int playerKeyCode;
    public final static double INVENTORY_CAPACITY = 20.0;

    public Player(String name, String description, double health, ArrayList<Item> inventory, int location, int damage, int playerKeyCode) {
        super(name, description, health);
        setInventory(inventory);
        setLocation(location);
        setDamage(damage);
        setPlayerKeyCode(playerKeyCode);
    }

    public Player() {
        super("", "", 0);
        setInventory(new ArrayList<>());
        setLocation(0);
        setDamage(2);
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public int getLocation() {
        return location;
    }

    public int getDamage() {
        return damage;
    }

    public int getPlayerKeyCode() {
        return playerKeyCode;
    }

    public double getInventoryWeight() {
        double weight = 0.0;
        for (Item item : inventory)
            weight += item.getWeight();
        return weight;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setPlayerKeyCode(int playerKeyCode) {
        this.playerKeyCode = playerKeyCode;
    }

    public void addItem(Item item){
        inventory.add(item);
    }

    public Item dropItem(String name) throws ItemDoesNotExistException {
        for (int i = 0; i < inventory.size(); i++) {
            Item drop = inventory.get(i);
            if (drop.getName().equals(name)) {
                inventory.remove(i);
                return drop;
            }
        }
        throw new ItemDoesNotExistException("You dont have an item named " + name);
    }

    public void showInventory() {
        System.out.print("You are carrying: ");
        if (inventory.size() > 0) {
            System.out.println();
            for (Item item : inventory)
                System.out.println("- " + item.getName());
        } else
            System.out.println("nothing");
    }

    public void interact(Player player) {
        player.showInventory();
    }

    public String toString() {
        return "{" + super.toString() + ", " + getInventory() + ", " + getLocation() + "}";
    }

    public String getData(){
        String playerData = getLocation() + ",PLAYER," + getName() + "," + getDescription() + "," + (int)getHealth() + "," + getDamage() + "," + getPlayerKeyCode();
        for(Item item : inventory){
            playerData += "," + item.getData();
        }
        return playerData;   
    }

    public void useItem(String itemName) {
        for (Item item : inventory)
            if (item.getName().equals(itemName))
                item.interact(this);
    }
}