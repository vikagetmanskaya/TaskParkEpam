package com.company;

public class Plant {
    private String name, type;
    private int height, index;

    public Plant(String name, String type, int height, int index) {
        this.name = name;
        this.type = type;
        this.height = height;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getHeight() {
        return height;
    }

    public int getIndex() {
        return index;
    }
}
