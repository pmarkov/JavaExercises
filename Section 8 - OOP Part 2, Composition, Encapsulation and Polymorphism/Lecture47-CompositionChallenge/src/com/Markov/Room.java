package com.Markov;

public class Room {

    private Door door;
    private Window window;
    private Floor floor;
    private Table table;
    private Chairs chairs;

    public Room(Door door, Window window, Floor floor, Table table, Chairs chairs) {
        this.door = door;
        this.window = window;
        this.floor = floor;
        this.table = table;
        this.chairs = chairs;
    }

    public void openWindow() {
        System.out.println("Room -> Opening window");
        window.windowCondition(1);
    }

    public void closeWindow() {
        System.out.println("Room -> Closing window");
        window.windowCondition(0);
    }

    public Door getDoor() {
        System.out.println("Room -> setting door");
        return door;
    }

}
