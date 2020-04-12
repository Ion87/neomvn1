package config;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLConfigurateProvider {
    public String getValue(String name,String filename) throws IOException, SAXException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(filename).getPath());
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            NodeList nodeList = document.getElementsByTagName("connection");
            Element element = (Element)nodeList.item(0);
            //System.out.println(String.valueOf(element.getElementsByTagName(name).item(0).getAttributes().getNamedItem("value")));
             return String.valueOf(element.getElementsByTagName(name).item(0).getAttributes().getNamedItem("value"));

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return null;
        }
            //Parser->keyName->return value
        }
}
//test XMLConfigurateProvider.getValue("key");
//test XMLConfigurateProvider.getValue("url");
//in dependenta de metoda Parsing aleasa posibil vamai trebui de adaugat inca un parametru la metoa: String fileName