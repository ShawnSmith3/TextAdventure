package main.models;

public class GameEntity {
    private String name;
    private String description;

    public void setName(String entityName){
        name = entityName;
    }
    
    public void setDescription(String entityDescription){
        description = entityDescription;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public String toString() {
        return "{" + getName() + ", " + getDescription() + "}";
    }
}
