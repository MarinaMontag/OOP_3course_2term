package controller.servlets;

import exception.ServerException;
import model.Subject;
import model.SubjectList;
import org.junit.Test;
import service.SubjectService;
import service.SubjectServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SubjectsServletTest {
    @Test
    public void testSubjectServlet() throws ServletException, IOException, ServerException {
        SubjectService service = mock(SubjectServiceImpl.class);
        List<Subject>subjects = new ArrayList<>();
        subjects.add(new Subject(1, "Algebra"));
        subjects.add(new Subject(2, "Geometry"));
        subjects.add(new Subject(3, "Biology"));
        subjects.add(new Subject(4, "Physics"));
        subjects.add(new Subject(5, "Geography"));
        subjects.add(new Subject(6, "Chemistry"));
        SubjectList list = new SubjectList(subjects);
        when(service.getSubjects()).thenReturn(list);
    }
}
