package controller.servlets;

import exception.ServerException;
import model.Role;
import model.Subject;
import model.SubjectList;
import model.User;
import org.junit.Test;
import service.SubjectService;
import service.SubjectServiceImpl;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoginServletTest {
    @Test
   public void testServlet() throws ServerException, ClassNotFoundException {
        UserService service = mock(UserServiceImpl.class);
        User user = new User("Marina", "Montag", "m@gmail.com", "mm", Role.TUTOR);
        when(service.getUser("m@gmail.com", "mm")).thenReturn(user);
    }
}
