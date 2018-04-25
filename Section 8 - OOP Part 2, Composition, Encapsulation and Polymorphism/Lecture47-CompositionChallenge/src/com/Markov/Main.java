package com.Markov;

public class Main {

    public static void main(String[] args) {

        Door door = new Door("PVC", new Dimensions(50, 200), "brown");
        Table table = new Table("Circle", "brown", new Dimensions(120, 80));
        Floor floor = new Floor("parquet", new Dimensions(500, 700));
        Window windows = new Window(new Dimensions(50, 100), 2, "PVC");
        Chairs chairs = new Chairs("wooden", 4);
        Room room = new Room(door, windows, floor, table, chairs);

        room.getDoor().openDoor();
        room.openWindow();
        room.getDoor().openDoor();
        room.getDoor().closeDoor();
        room.closeWindow();

    }
}
