package Servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by james on 10/8/2016.
 */
@WebServlet("/index.jsp")
public class MainPageServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        //request.setAttribute("recentlySoldList",
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }

}
