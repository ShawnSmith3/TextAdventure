package main;

import java.util.HashMap;
import java.io.*;

import main.models.Room;

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

    }
}
