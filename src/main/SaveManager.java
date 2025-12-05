package main;

import java.io.*;
import java.util.*;
import main.models.Player;
import main.models.Room;



public class SaveManager {
    
    public static void saveGame(HashMap<Integer, Room> rooms, Player player){
        try(PrintWriter writer = new PrintWriter(new FileWriter("src/world/savegame.csv"))){
            writer.println(player.getData());
            writer.close();
        }
        catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        
    }
}
