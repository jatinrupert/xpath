//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.06.19 at 12:47:00 PM BST 
//


package xpath.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the xpath.schema package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Students_QNAME = new QName("", "students");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: xpath.schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StudentsType }
     * 
     */
    public StudentsType createStudentsType() {
        return new StudentsType();
    }

    /**
     * Create an instance of {@link StudentType }
     * 
     */
    public StudentType createStudentType() {
        return new StudentType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StudentsType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StudentsType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "students")
    public JAXBElement<StudentsType> createStudents(StudentsType value) {
        return new JAXBElement<StudentsType>(_Students_QNAME, StudentsType.class, null, value);
    }

}
