package com.company;

import java.util.ArrayList;

public class Nature {
    private ArrayList<Plant> plantList;
    private Park park;

    public Park getPark() {
        return park;
    }

    public void setPlantList(ArrayList<Plant> plantList) {

        this.plantList = plantList;
    }

    public void printPlantList() {
        System.out.println("Растения");
        for (Plant plant : plantList) {
            System.out.println("Имя " + plant.getName() + ", тип " + plant.getType() + ", высота " + plant.getHeight());
        }
        System.out.println();
    }

    public void printPark() {
        System.out.println("Парк");
        System.out.println("Имя: " + park.getName() + "; Общая высота: " + park.getHeight() + "; Количество деревьев: " + park.getKol_vo());
        for (int i = 0; i < park.getPlantList().size(); i++) {
            System.out.println("Имя " + park.getPlantList().get(i).getName() + ", тип " + park.getPlantList().get(i).getType() + ", высота " +
                    park.getPlantList().get(i).getHeight());
        }
    }

    public void createPark() {
        String name = "Парк имени Янки Купалы";
        ArrayList<Plant> parkPlantList = assemblePark();
        int height = calculateHeight(parkPlantList);
        int kol_vo = calculateKol_vo(parkPlantList);
        park = new Park(name, height, kol_vo, parkPlantList);
    }

    public ArrayList<Plant> assemblePark() {
        ArrayList<Plant> parkPlantList = new ArrayList<>();
        for (Plant plant : plantList) {
            if (plant.getType().equals("Дерево")  && (plant.getIndex() == 1 || plant.getIndex() == 2  ) ) {
                parkPlantList.add(plant);
            }else if (plant.getType().equals("Кустарник") && (plant.getIndex() == 1 || plant.getIndex() == 2 ) ) {
                parkPlantList.add(plant);
            }
        }
        return parkPlantList;
    }


    public int calculateHeight (ArrayList <Plant> plantList) {
        int height = 0;
        for (Plant plant : plantList) {
            height += plant.getHeight();
        }
        return height;
    }
    public int calculateKol_vo(ArrayList <Plant> plantList){
        int kol_vo = 0;
        for(Plant plant: plantList){
            kol_vo++;
        }
        return kol_vo;
    }
}



