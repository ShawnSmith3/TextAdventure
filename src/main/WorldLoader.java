package main;

import java.util.HashMap;
import java.io.*;

import main.models.*;

public class WorldLoader {
    public static HashMap<Integer, Room> loadRooms(String filePath) {
        HashMap<Integer, Room> rooms = new HashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parameters = line.split(",");
                
                int roomID = Integer.valueOf(parameters[0]);
                String name = parameters[1];
                String description = parameters[2];

                HashMap<String, Integer> exits = new HashMap<>();
                exits.put("north", Integer.valueOf(parameters[3]));
                exits.put("south", Integer.valueOf(parameters[4]));
                exits.put("east", Integer.valueOf(parameters[5]));
                exits.put("west", Integer.valueOf(parameters[6]));

                rooms.put(roomID, new Room(roomID, name, description, exits));
            }
        } catch (FileNotFoundException exception) {
            System.out.println("File was not found: " + filePath);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        return rooms;
    }

    public static void loadObjects(String filePath, HashMap<Integer, Room> rooms) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parameters = line.split(",");

                int location_id = Integer.valueOf(parameters[0]);
                String type = parameters[1];
                if (type.equals("MONSTER")) {
                    rooms.get(location_id).addMonster(loadMonster(parameters, 2));
                } else {
                    rooms.get(location_id).addItem(loadItem(parameters, 1));
                }
            }
        } catch (FileNotFoundException exception) {
            System.out.println("File was not found: " + filePath);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static Item loadItem(String[] parameters, int offset) throws IOException {
        String type = parameters[offset++];
        String name = parameters[offset++];
        String description = parameters[offset++];
        double weight = Double.valueOf(parameters[offset++]);
        int value = Integer.valueOf(parameters[offset]);
        switch (type) {
            case "WEAPON":
                return new Weapon(name, description, weight, value);
            case "KEY":
                return new Key(name, description, weight, value);
            case "POTION":
                return new Potion(name, description, weight, value);
            default:
                throw new IOException("FATAL: Wrong item type");
        }
    }

    private static Monster loadMonster(String[] parameters, int offset) throws IOException {
        String name = parameters[offset++];
        String description = parameters[offset++];
        int health = Integer.valueOf(parameters[offset++]);
        int damage = Integer.valueOf(parameters[offset++]);
        Item loot = loadItem(parameters, offset);
        //return new Monster(name, description, health, damage, loot);
        return new Monster();
    }
}
