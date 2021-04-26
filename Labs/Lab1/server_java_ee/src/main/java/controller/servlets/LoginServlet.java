package controller.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import exception.ServerException;
import model.User;
import service.UserService;
import service.UserServiceImpl;
import util.JsonConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
    }

    public LoginServlet(){
        userService = new UserServiceImpl();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            String json = JsonConverter.getJsonFromRequest(req, resp);
            User user = new ObjectMapper().readValue(json, User.class);
            user = userService.getUser(user.getEmail(), user.getPassword());
            if (user == null) {
                resp.sendError(403, "You are not registered");
            } else {
                JsonConverter.makeResponse(user, resp);
            }
        } catch (ServerException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }
}
