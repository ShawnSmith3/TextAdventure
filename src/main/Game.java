package main;

import java.util.*;

import main.models.*;

public class Game {
    private static HashMap<Integer, Room> rooms;
    private static Player player;
    private static Scanner scan;

    public static void main(String[] args) {
        // load game
        rooms = WorldLoader.loadRooms("src/world/rooms.csv");
        player = WorldLoader.loadObjects("src/world/objects.csv", rooms);
        scan = new Scanner(System.in);
        
        System.out.println("Welcome to the Text Adventure!");

        // game loop
        String input = "";
        while (!input.equals("quit")) {
            // describe room
            Room room = rooms.get(player.getLocation());
            System.out.print("--- " + room.getName() + " ---\n"
                            + room.getDescription() + "\n\n"
                            + "You see: ");
            
            // describe objects in room
            ArrayList<Item> itemsInRoom = room.getItemsInRoom();
            ArrayList<Monster> monstersInRoom = room.getMonstersInRoom();
            if (itemsInRoom.size() > 0 || monstersInRoom.size() > 0) {
                System.out.println();
                for (Item item : itemsInRoom)
                    System.out.println("- " + item.getName());
                for (Monster monster : monstersInRoom)
                    System.out.println("- " + monster.getName());
            } else
                System.out.println("Nothing");
            System.out.println();

            // describe exits from room
            System.out.print("Exits are: ");
            HashMap<String, Integer> exits = room.getExits();
            for (Map.Entry<String, Integer> exit : exits.entrySet())
                if (exit.getValue() != -1)
                    System.out.print(exit.getKey() + " ");
            System.out.println("\n");

            // commands
            // get <item name>
            // attack <monster name>
            // drop <item name>
            // use <potion name or key name>
            // i (view inventory)
            // quit (save and quit)

            // command loop
            while (true) {
                System.out.println("Enter a command: ");
                input = scan.nextLine();
                String[] split = input.split(" ");
                String command = split[0];
                String keyword = "";
                if (split.length > 1)
                    for (int i = 1; i < split.length; i++) {
                        keyword += split[i];
                        if (i != split.length - 1)
                            keyword += " ";
                    }
                        
                break;
            }
        }

        SaveManager.saveGame(rooms, player);

        scan.close();

        System.out.println("Thanks for playing!");
    }
}
