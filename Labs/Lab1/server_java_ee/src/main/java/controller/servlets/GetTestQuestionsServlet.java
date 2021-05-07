package controller.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import exception.ServerException;
import model.CreatedTest;
import model.QuestionList;
import model.User;
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

@WebServlet(urlPatterns = {"/questions"})
public class GetTestQuestionsServlet extends HttpServlet {
    private TestService testService;

    @Override
    public void init() throws ServletException {
        testService = new TestServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int testId = Integer.parseInt(req.getParameter("id"));
        try {
                QuestionList list = testService.getQuestionAndAnswersByTestId(testId);
                if (list.getQuestions() == null || list.getQuestions().size() == 0)
                    resp.sendError(404, "Resource not found");
                else
                    JsonConverter.makeResponse(list, resp);
        } catch (ServerException e) {
            resp.sendError(404, e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        try {
            String json = JsonConverter.getJsonFromRequest(req, resp);
            CreatedTest test = new ObjectMapper().readValue(json, CreatedTest.class);
            testService.createTest(test);
            if (test == null) {
                resp.sendError(403, "Something wrong with your test");
            } else {
                PrintWriter writer = resp.getWriter();
                try {
                    writer.write("Test has been successfully created");
                }finally {
                    writer.close();
                }
            }
        } catch (ServerException e) {
            e.printStackTrace();
        }
    }
}
