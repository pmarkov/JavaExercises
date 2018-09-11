package com.Markov;

public class Table {
    private String tableType;
    private String color;
    private Dimensions dimensions;

    public Table(String tableType, String color, Dimensions dimensions) {
        this.tableType = tableType;
        this.color = color;
        this.dimensions = dimensions;
    }

    public String getTableType() {
        return tableType;
    }

    public String getColor() {
        return color;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }
}
