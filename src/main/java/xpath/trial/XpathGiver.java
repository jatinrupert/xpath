package xpath.trial;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class XpathGiver {

    public static String valueOf(String xpathValue) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {

        // Get DOM
        final Document xml = xml();
        // Get XPath
        final XPath xpath = xpath();

        return (String)xpath.evaluate(xpathValue, xml, XPathConstants.STRING);
    }

    public static NodeList nodesOf(String xpathValue) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {

        // Get DOM
        final Document xml = xml();
        // Get XPath
        final XPath xpath = xpath();

        return (NodeList)xpath.evaluate(xpathValue, xml, XPathConstants.NODESET);
    }

    private static XPath xpath() {
        final XPathFactory xpf = XPathFactory.newInstance();
        return xpf.newXPath();
    }

    private static Document xml() throws ParserConfigurationException, IOException, SAXException {
        final ClassLoader classLoader = XpathGiver.class.getClassLoader();
        final File xmlFile = new File(classLoader.getResource("xml/student.xml").getFile());

        // Get DOM
        final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        final DocumentBuilder db = dbf.newDocumentBuilder();
        final Document xml = db.parse(xmlFile);
        xml.getDocumentElement().normalize();

        return xml;
    }
}
