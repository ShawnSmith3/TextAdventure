package main.models;

public class ItemDoesNotExistException extends Exception {
    public ItemDoesNotExistException(String message) {
        super(message);
    }
}
