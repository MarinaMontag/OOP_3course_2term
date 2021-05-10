package controller.servlets.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SendResponse {
    public static void sendResponse(String resp, HttpServletResponse response)
            throws IOException
    {
        PrintWriter writer = response.getWriter();
        try {
            writer.write(resp);
        }finally {
            writer.close();
        }
    }
}
