package main.models;

import java.util.HashMap;
import java.util.ArrayList;

public class Room {
    // instance data

    private int roomID;
    private String name;
    private String description;
    private HashMap<String, Integer> exits;
    private ArrayList<Item> itemsInRoom;
    private ArrayList<Monster> monstersInRoom;

    // constructors

    public Room(int roomID,
        String name,
        String description,
        HashMap<String, Integer> exits) {
        setRoomID(roomID);
        setName(name);
        setDescription(description);
        setExits(exits);
    }

    // getters

    public int getRoomID() {
        return roomID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public HashMap<String, Integer> getExits() {
        return exits;
    }

    public ArrayList<Item> getItemsInRoom() {
        return itemsInRoom;
    }

    public ArrayList<Monster> getMonstersInRoom() {
        return monstersInRoom;
    }

    // setters

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExits(HashMap<String, Integer> exits) {
        this.exits = exits;
    }

    public void setItemsInRoom(ArrayList<Item> itemsInRoom) {
        this.itemsInRoom = itemsInRoom;
    }

    public void setMonstersInRoom(ArrayList<Monster> monstersInRoom) {
        this.monstersInRoom = monstersInRoom;
    }

    // toString

    public String toString() {
        return "{" + getRoomID() + ", " + getName() + ", " + getDescription() + ", " + getExits() + ", " + getItemsInRoom() + ", " + getMonstersInRoom() + "}";
    }
}
