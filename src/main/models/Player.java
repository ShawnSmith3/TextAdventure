package main.models;

import java.util.ArrayList;

import main.Interfaces.Interactable;

public class Player extends Creature implements Interactable {
    private ArrayList<Item> inventory;
    private int location;

    public Player(String name, String description, int health, ArrayList<Item> inventory, int location) {
        super(name, description, health);
        setInventory(inventory);
        setLocation(location);
    }

    public Player() {
        super("", "", 0);
        setInventory(new ArrayList<>());
        setLocation(0);
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public int getLocation() {
        return location;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public void setLocation(int location) {
        this.location = location;
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
        System.out.println(inventory);
    }

    public void interact(Player player) {
        player.showInventory();
    }

    public String toString() {
        return "{" + super.toString() + ", " + getInventory() + ", " + getLocation() + "}";
    }
}