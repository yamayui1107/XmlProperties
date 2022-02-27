package readXmlProperties;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlPropertiesReader {
    private XmlPropertiesReader(){}

    public static Map<String, List<String>> getProperties(String xmlFilePath) throws ParserConfigurationException, IOException, SAXException {

        //xmlファイルを取得
        File xmlFile = new File(xmlFilePath);

        //xmlファイルからプロパティを取得
        Map<String, List<String>> xmlProperties = getXmlProperties(xmlFile);

        return xmlProperties;
    }

    private static Map<String, List<String>> getXmlProperties(File xmlFile) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(xmlFile);

        Element properties = document.getDocumentElement();

        NodeList property = properties.getElementsByTagName("property");

        Map<String, List<String>> xmlProperties = new HashMap<>();
        for(int i = 0; i < property.getLength(); i++){
            Element e = (Element) property.item(i);

            String key = e.getAttribute("key");
            if(!xmlProperties.containsKey(key)){
                xmlProperties.put(key, new ArrayList<>());
            }
            String value = e.getTextContent();
            xmlProperties.get(key).add(value);
        }

        return xmlProperties;
    }
}
