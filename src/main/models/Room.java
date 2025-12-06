package main.models;

import java.util.HashMap;
import java.util.ArrayList;

public class Room extends GameEntity {
    // instance data

    private int roomID;
    private HashMap<String, Integer> exits;
    private ArrayList<Item> itemsInRoom;
    private ArrayList<Monster> monstersInRoom;

    // constructors

    public Room(int roomID,
        String name,
        String description,
        HashMap<String, Integer> exits) {
        super(name, description);
        setRoomID(roomID);
        setExits(exits);
        setItemsInRoom(new ArrayList<Item>());
        setMonstersInRoom(new ArrayList<Monster>());
    }

    // getters

    public int getRoomID() {
        return roomID;
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

    public Integer getExit(String key) {
        return exits.get(key);
    }

    public Item getItemInRoom(int i) {
        return itemsInRoom.get(i);
    }

    public Monster getMonsterInRoom(int i) {
        return monstersInRoom.get(i);
    }

    // setters

    public void setRoomID(int roomID) {
        this.roomID = roomID;
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

    public void addExit(String key, Integer value) {
        exits.put(key, value);
    }

    public void addItem(Item item) {
        itemsInRoom.add(item);
    }

    public void addMonster(Monster monster) {
        monstersInRoom.add(monster);
    }

    public void removeItem(Item item) {
        itemsInRoom.remove(item);
    }

    public void removeMonster(Monster monster) {
        monstersInRoom.remove(monster);
    }

    // toString

    public String toString() {
        return "{" + getRoomID() + ", " + super.toString() + ", " + getExits() + ", " + getItemsInRoom() + ", " + getMonstersInRoom() + "}";
    }
}