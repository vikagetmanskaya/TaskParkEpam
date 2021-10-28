package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PlantListImporter {
    private static ArrayList<Plant> plantList = new ArrayList<>();

    public PlantListImporter(ArrayList<Plant> plantList) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        this.plantList = plantList;
        AdvancedXMLHandler handler = new AdvancedXMLHandler();
        parser.parse(new File("src/com/company/plants.xml"), handler);

    }

    private static class AdvancedXMLHandler extends DefaultHandler {
        private String lastElementName;
        private String name;
        private String type;
        private String height;
        private String index;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            lastElementName = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (lastElementName == null) {
                return;
            } else if (lastElementName.equals("name")) {
                name = new String(ch, start, length);
            } else if (lastElementName.equals("type")) {
                type = new String(ch, start, length);
            } else if (lastElementName.equals("height")) {
                height = new String(ch, start, length);
            } else if (lastElementName.equals("index")) {
                index = new String(ch, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (qName.equals("plant")) {
                Plant plant = new Plant(name, type, Integer.parseInt(height), Integer.parseInt(index));
                plantList.add(plant);
                name = null;
                type = null;
                height = null;
                index = null;

            }
        }
    }
}