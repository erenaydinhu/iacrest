package eren.test;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.core.DefaultResourceConfig;
import com.sun.jersey.spi.container.servlet.WebComponent;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;

import eren.service.RESTServiceTwo;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringReader;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import junit.framework.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class IntegrationTest extends JerseyTest {


    public static class AppConfig extends DefaultResourceConfig {
        public AppConfig() {
            super(RESTServiceTwo.class);
        }
    }

    @Override
    public WebAppDescriptor configure() {
        return new WebAppDescriptor.Builder()
                .initParam(WebComponent.RESOURCE_CONFIG_CLASS, 
                           AppConfig.class.getName())
                .build();
    }

    @Test
    public void doTest() throws ParserConfigurationException, SAXException, IOException {
        WebResource resource = resource().path("distanceservice/35/32/55/56");
        String result = resource.get(String.class);
     
       
        String[] endresult = result.split("\\s+");
       
        System.out.println(endresult[1]);
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource src = new InputSource();
        src.setCharacterStream(new StringReader(result));

        assertEquals(2885, Double.parseDouble(endresult[1]), 5);
       // System.out.println(result);
    }
}