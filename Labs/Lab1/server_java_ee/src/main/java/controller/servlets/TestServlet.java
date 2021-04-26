package controller.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import exception.ServerException;
import model.SubjectList;
import model.Test;
import model.TestList;
import service.SubjectServiceImpl;
import service.TestService;
import service.TestServiceImpl;
import util.JsonConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns = {"/tests"})
public class TestServlet extends HttpServlet {
    private TestService service;

    @Override
    public void init() throws ServletException {
        service=new TestServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        if(id>=1&&id<=6){
            TestList list;
            try {
                list = service.getTestsBySubjectId(id);
                if (list.getTestList() == null || list.getTestList().size() == 0)
                    resp.sendError(404, "Resource not found");
                else
                    JsonConverter.makeResponse(list, resp);
            } catch (ServerException e) {
                resp.sendError(404, "Resource not found");
            }
        }
        else{
            resp.sendError(400, "Bad request");
        }
    }
}
