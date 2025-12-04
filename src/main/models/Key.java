package main.models;

public class Key {
    private String name;
    private String description;
    private double weight;
    private int keyID;

   public Key(String name, String description, double weight, int keyID){
    this.name = name;
    this.description = description;
    this.weight = weight;
    this.keyID = keyID;
   }

  public void setName(String keyName){
    name = keyName;
  }

  public void setDescription(String keyDescription){
    description = keyDescription;
  }

  public void setWeight(double keyWeight){
    weight = keyWeight;
  }

  public void setKeyID(int keyID){
    this.keyID = keyID; 
  }

  public String getName(){
    return name;
  }
  
  public String getDescription(){
    return description;
  }

  public double getWeight(){
    return weight;
  }

  public int getKeyID(){
    return keyID;
  }

  void interact(Player player){

   }
}
