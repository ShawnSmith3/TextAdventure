package main.models;

public class Key extends Item {
    private int keyID;

    public Key(String name, String description, double weight, int keyID){
        super(name, description, weight);
        this.keyID = keyID;
    }

    public void setKeyID(int keyID){
        this.keyID = keyID; 
    }

    public int getKeyID(){
        return keyID;
    }

    void interact(Player player){
        
    }
}