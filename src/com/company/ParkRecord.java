package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;

public class ParkRecord {
    public ParkRecord(Park park){
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document = null;
        try {
            factory = DocumentBuilderFactory.newInstance(); //получение фабрики, чтобы получить билдер документов
            builder = factory.newDocumentBuilder(); //получение билдера, который парсит XML, создает структуру Document в виде иерархического дерева
            document = builder.newDocument(); //создание нового документа
            Element element = document.createElement("park");
            document.appendChild(element);
            addElements(document, element, "name", park.getName());
            addElements(document, element, "height", Integer.toString(park.getHeight()));
            addElements(document, element, "kol_vo", Integer.toString(park.getKol_vo()));
            for (int i = 0; i < park.getPlantList().size(); i++) {
                Element plant = document.createElement("plant");
                element.appendChild(plant);
                addElements(document, plant, "name", park.getPlantList().get(i).getName());
                addElements(document, plant, "type", park.getPlantList().get(i).getType());
                addElements(document, plant, "height", Integer.toString(park.getPlantList().get(i).getHeight()));
            }
        }catch (ParserConfigurationException e) {
        e.printStackTrace();
    }finally {
        writeDocument(document);
    }
    }

    private void addElements(Document document, Element park, String attribute, String value) {
        Element element = document.createElement(attribute);
        element.appendChild(document.createTextNode(value));
        park.appendChild(element);
    }

    private void writeDocument(Document document) throws TransformerFactoryConfigurationError{
        Transformer trf;
        DOMSource src;
        FileOutputStream fos;
        try {
            trf = TransformerFactory.newInstance().newTransformer();
            trf.setOutputProperty(OutputKeys.INDENT, "yes");
            src = new DOMSource(document);
            fos = new FileOutputStream("src/com/company/park.xml");
            StreamResult result = new StreamResult(fos);
            trf.transform(src, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}