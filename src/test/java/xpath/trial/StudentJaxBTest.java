package xpath.trial;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import xpath.schema.StudentType;
import xpath.schema.StudentsType;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StudentJaxBTest {

    private final JaxBUnmarshaller unmarshaller = new JaxBUnmarshaller();

    @Test
    public void shouldWork() throws IOException {
        String xml = getStudents();

        assertNotNull(xml);
    }

    @Test
    public void studentName() throws IOException, JAXBException {

        final StudentsType students = unmarshaller.unmarshallElement(getStudents());

        assertEquals("Aniket Chauhan", students.getStudent().get(1).getName());
    }

    @Test
    public void branchList() throws IOException, JAXBException {

        final StudentsType students = unmarshaller.unmarshallElement(getStudents());
        // find specific students name whose branch is IT
        List<StudentType> branches = students.getStudent().stream().filter(x -> "IT".equalsIgnoreCase(x.getBranch())).collect(Collectors.toList());

        assertEquals(2, branches.size());
        assertEquals("Anuj Modi", branches.get(1).getName());

    }

    private String getStudents() throws IOException {
        return IOUtils.toString(
                Objects.requireNonNull(this.getClass().getResourceAsStream("/xml/student.xml")),
                StandardCharsets.UTF_8
        );
    }
}
