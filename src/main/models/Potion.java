package main.models;

public class Potion extends Item {
    private int healAmount;
    
    public Potion(String name, String description, double weight, int healAmount){
        super(name, description, weight);
        this.healAmount = healAmount;
    }

    public void setHealAmount(int potionHealAmount){
        healAmount = potionHealAmount;
    }

    public double getHealAmount(){
        return healAmount;
    }

    public String toString() {
        return "{" + super.toString() + ", " + getHealAmount() + "}";
    }

    public void interact(Player player) {
        player.setHealth(player.getHealth() + getHealAmount());
        System.out.println("You gained " + getHealAmount() + " health!");
    }
    
    public String getData(){
        return "POTION," + getName() + "," + getDescription() + "," + getWeight() + "," + getHealAmount();   
    }

}
