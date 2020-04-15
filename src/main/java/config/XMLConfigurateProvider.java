package config;

import org.w3c.dom.*;
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

            Node item = element.getElementsByTagName(name).item(0);
            Attr value = (Attr)item.getAttributes().getNamedItem("value");
            return value.getValue();

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