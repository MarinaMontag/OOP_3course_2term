package controller.servlets;

import exception.ServerException;
import model.Subject;
import service.SubjectService;
import service.SubjectServiceImpl;
import util.JsonConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/subjects")
public class SubjectsServlet extends HttpServlet {
    private SubjectService subjectService;
    SubjectsServlet(){
        super();
        subjectService=new SubjectServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Access-Control-Allow-Origin", "*");
        try {
            List<Subject>subjects=subjectService.getSubjects();
            if(subjects==null||subjects.size()==0)
                resp.sendError(404,"Resource not found");
            else
                JsonConverter.makeResponse(subjects, resp);
        } catch (ServerException e) {
            e.printStackTrace();
        }
    }
}
