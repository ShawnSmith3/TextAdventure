package main;

import java.util.HashMap;
import java.util.ArrayList;

import main.models.Room;
import main.models.Player;
import main.models.Item;

public class Game {
    private static HashMap<Integer, Room> rooms;
    private static Player player;

    public static void main(String[] args) {
        // load game
        rooms = WorldLoader.loadRooms("src/world/rooms.csv");
        player = WorldLoader.loadObjects("src/world/objects.csv", rooms);
        
        System.out.println("Welcome to the Text Adventure!");

        // game loop
        while (true) {
            Room room = rooms.get(player.getLocation());
            System.out.println("--- " + room.getName() + " ---\n"
                            + room.getDescription() + "\n");
            
            ArrayList<Item> itemsInRoom = room.getItemsInRoom();
            //if (itemsInRoom.size() > 0)
                //for (Item item : itemsInRoom)
                
                
            break;
        }
    }
}
