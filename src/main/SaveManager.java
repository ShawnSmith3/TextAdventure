package main;

import java.io.*;
import java.util.*;
import main.models.*;




public class SaveManager {
    
    public static void saveGame(HashMap<Integer, Room> rooms, Player player){
        System.out.println("Saving game...");
        try(PrintWriter writer = new PrintWriter(new FileWriter("src/world/savegame.csv"))){
            writer.println(player.getData());
            writer.close();

            for(Room room : rooms.values()){
                for(Monster monster : room.getMonstersInRoom()){
                    writer.println(room.getRoomID() + "," + (monster.getData()));
                }
                for(Item item : room.getItemsInRoom()){
                    writer.println(room.getRoomID() + "," + item.getData());
                }
            }
            System.out.println("Game saved.");
        }
        catch (IOException exception){
            System.out.println(exception.getMessage());
        }
        
    }


public static Player loadGame(HashMap<Integer, Room> rooms){
    File saveGame = new File("src/world/savegame.csv");

    if(!saveGame.exists()){
        System.out.println("No save file found.");
        return new Player();
    }
    return WorldLoader.loadObjects("src/world/savegame.csv", rooms);
    
        }
    }
    
