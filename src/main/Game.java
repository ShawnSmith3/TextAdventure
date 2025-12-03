package main;

import java.util.HashMap;

import main.models.Room;

public class Game {
    private static HashMap<Integer, Room> rooms;
    private static WorldLoader worldLoader;
    private static SaveManager saveManager;
    public static void main(String[] args) {
        System.out.println("Welcome to the Text Adventure!");
    }
}
