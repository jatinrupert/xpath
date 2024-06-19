package xpath.trial;

import org.junit.Test;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StudentTest {

    @Test
    public void studentName() throws ParserConfigurationException,
            IOException, SAXException, XPathExpressionException {

        // Find 2nd Student's name
        String name = XpathGiver.valueOf("/students/student[2]/name");

        assertEquals("Aniket Chauhan", name);
    }

    @Test
    public void branchList() throws ParserConfigurationException,
            IOException, SAXException, XPathExpressionException {

        // find specific students name whose branch is IT
        NodeList branches = XpathGiver.nodesOf("/students/student[@branch = \"IT\"]/name");

        assertEquals(2, branches.getLength());

        final List<String> values = nodes(branches);
        assertEquals("Anuj Modi", values.get(1));

    }

    @Test
    public void ages() throws ParserConfigurationException,
            IOException, SAXException, XPathExpressionException {

        // find specific students name whose age is less  than equal to 20
        NodeList branches = XpathGiver.nodesOf("/students/student[age <= 20]/name");

        assertEquals(3, branches.getLength());

        final List<String> values = nodes(branches);
        assertEquals("Abhay Chauhan", values.get(2));

    }

    @Test
    public void students() throws ParserConfigurationException,
            IOException, SAXException, XPathExpressionException {

        // First 4 students from XML document
        NodeList branches = XpathGiver.nodesOf("/students/student[position() < 5]/name");

        assertEquals(4, branches.getLength());

        final List<String> values = nodes(branches);
        assertEquals("Abhay Chauhan", values.get(3));

    }

    private List<String> nodes(NodeList nodes)
    {
        final List<String> values = new ArrayList<>();
        for (int i = 0; i < nodes.getLength(); i++) {
            values.add(nodes.item(i).getTextContent());
        }

        return values;
    }
}
