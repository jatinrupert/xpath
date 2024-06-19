package xpath.trial;

import xpath.schema.StudentsType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;

public class JaxBUnmarshaller {

    public StudentsType unmarshall(String xmlString) throws JAXBException {
        JAXBContext jaxbContext;
            jaxbContext = JAXBContext.newInstance(StudentsType.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (StudentsType) jaxbUnmarshaller.unmarshal(new StringReader(xmlString));
    }

    public StudentsType unmarshallElement(String xmlString) throws JAXBException {
        JAXBContext jaxbContext;
        jaxbContext = JAXBContext.newInstance(StudentsType.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        JAXBElement<StudentsType> jaxbElement = jaxbUnmarshaller
                .unmarshal(new StreamSource(new StringReader(xmlString)), StudentsType.class);
        return jaxbElement.getValue();
    }
}
