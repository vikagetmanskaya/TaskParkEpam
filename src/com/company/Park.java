package com.company;

import java.util.ArrayList;

public class Park {
    private String name;
    private int height, kol_vo;
    private ArrayList<Plant> plantList;

    public Park(String name, int height, int kol_vo, ArrayList<Plant> plantList) {
        this.name = name;
        this.height = height;
        this.kol_vo = kol_vo;
        this.plantList = plantList;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getKol_vo() {
        return kol_vo;
    }
    public ArrayList<Plant> getPlantList() {
        return plantList;
    }
}
