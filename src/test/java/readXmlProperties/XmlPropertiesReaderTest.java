package readXmlProperties;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class XmlPropertiesReaderTest {

    @org.junit.jupiter.api.Test
    void getProperties() throws ParserConfigurationException, IOException, SAXException {
        Map<String, List<String>> xml = XmlPropertiesReader.getProperties("/Users/yamamurayuinin/program_work/javaProgram/searchTweet/properties.xml");
        for(String str : xml.keySet()){
            for (String s : xml.get(str)){
                System.out.println(str + " " + s);
            }
        }
    }
}