package main;

import java.util.HashMap;

import main.models.Room;
import main.models.Player;

public class Game {
    private static HashMap<Integer, Room> rooms;
    private static Player player;

    public static void main(String[] args) {
        // load game
        rooms = WorldLoader.loadRooms("src/world/rooms.csv");
        player = WorldLoader.loadObjects("src/world/objects.csv", rooms);
        
        System.out.println("Welcome to the Text Adventure!");

        // game loop
    }
}
