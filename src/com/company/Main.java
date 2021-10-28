package com.company;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        ArrayList<Plant> plantList = new ArrayList<>();
        new PlantListImporter(plantList);
        Nature nature = new Nature();
        nature.setPlantList(plantList);
        nature.printPlantList();
        nature.createPark();
        nature.printPark();
        Park park = nature.getPark();
        new ParkRecord(park);

    }
}
