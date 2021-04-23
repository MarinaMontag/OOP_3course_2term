package util;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonConverter {
    public static String getJsonFromRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        StringBuffer json = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = req.getReader();
            while((line=reader.readLine())!=null){
                json.append(line);
            }
        } catch (IOException e) {
            resp.sendError(400, "Bad request: can not get json object");
        }
        return json.toString();
    }

    public static <T> void makeResponse(T obj, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.write(new ObjectMapper().writeValueAsString(obj));
    }
}
