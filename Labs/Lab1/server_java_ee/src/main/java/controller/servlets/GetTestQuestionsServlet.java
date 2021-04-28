package controller.servlets;

import exception.ServerException;
import model.QuestionList;
import service.TestService;
import service.TestServiceImpl;
import util.JsonConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
}
