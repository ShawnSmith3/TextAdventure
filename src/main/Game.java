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
            // go <north, south, east, or west>
            // attack <monster name>
            // drop <item name>
            // use <item name>
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
                
                switch (command) {
                    case "get":
                        for (int i = 0; i < itemsInRoom.size(); i++)
                            if (keyword.equals(itemsInRoom.get(i).getName()))
                                if (player.getInventoryWeight() + itemsInRoom.get(i).getWeight() > Player.INVENTORY_CAPACITY)
                                    System.out.println("You can't pick up " + keyword + " because it is too heavy. Maybe try dropping an item from your inventory.");
                                else {
                                    player.addItem(itemsInRoom.get(i));
                                    room.removeItem(itemsInRoom.get(i));
                                    System.out.println("You picked up the " + keyword);
                                }
                            else
                                System.out.println(keyword + " is not in the room");
                        break;
                    case "go":
                        if (room.getExits().containsKey(keyword) && room.getExit(keyword) != -1)
                            player.setLocation(room.getExit(keyword));
                        else
                            System.out.println("You can't go " + keyword);
                        break;
                    case "attack":
                        break;
                    case "drop":
                        try {
                            Item item = player.dropItem(keyword);
                            room.addItem(item);
                            System.out.println("You dropped " + keyword);
                        } catch (ItemDoesNotExistException exception) {
                            System.out.println(exception.getMessage());
                        }
                        break;
                    case "use":
                        player.useItem(keyword);
                        break;
                    case "i":
                        player.showInventory();
                        break;
                    case "quit":
                        break;
                    default:
                        System.out.println("Unrecognised command, try again.");
                }
                        
                break;
            }
        }

        SaveManager.saveGame(rooms, player);

        scan.close();

        System.out.println("Thanks for playing!");
    }
}
