package Servlets;

import Services.DistributorService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by james on 10/10/2016.
 */
@WebServlet("/AddDistributor.jsp")
public class AddDistributor extends HttpServlet {
    private static long serialVersionUID = 1L;
    boolean result = false;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String website = req.getParameter("website");
        String urlfeed = req.getParameter("urlfeed");

        DistributorService service = new DistributorService();
        result = service.addDistributor(name, email, phone, website, urlfeed);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }
}
