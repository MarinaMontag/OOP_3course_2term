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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String json = JsonConverter.getJsonFromRequest(req,resp);
        User user = new ObjectMapper().readValue(json, User.class);
        try {
            user = userService.createUser(user);
            if(user == null){
                resp.sendError(400, "Bad request");
            }else{
                JsonConverter.makeResponse(user, resp);
            }
        } catch (ServerException | ClassNotFoundException e) {
            resp.sendError(400, "Bad request");
            e.printStackTrace();
        }
    }
}
