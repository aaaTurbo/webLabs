package servlets;

import beans.StorageBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/areaChecker")
public class AreaChecker extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        if (req.getParameterNames().hasMoreElements()) {
            float x = Float.parseFloat(req.getParameter("x").replace(",", "."));
            float y = Float.parseFloat(req.getParameter("y").replace(",", "."));
            float r = Float.parseFloat(req.getParameter("r"));
            String time = req.getParameter("time");
            if (r != 1 && r != 1.5 && r != 2 && r != 2.5 && r != 3) {
                resp.setStatus(400);
                resp.getWriter().write("WRONG R!");
                return;
            }
            if (y <= -3 || y >= 3) {
                resp.setStatus(400);
                resp.getWriter().write("WRONG Y!");
                return;
            }
            if (x <= -5 || x >= 3) {
                resp.setStatus(400);
                resp.getWriter().write("WRONG X!");
                return;
            }
            boolean firstQuoter = false;
            boolean secondQuoter = false;
            boolean fourthQuoter = false;
            if (x < r/2 && x >= 0 && y >= 0 && y < r) {
                firstQuoter = true;
            }
            if (x > -r/2 && x <= 0 && y >= 0 && y < r && r/2 > y - x) {
                secondQuoter = true;
            }
            if (x >= 0 && x < r && y > -r && y <= 0 && r * r > x * x + y * y) {
                fourthQuoter = true;
            }
            StorageBean.addItem("<tr>"
                    + "<th>" + new Date(time) + "</th>"
                    + "<th>" + (firstQuoter || secondQuoter || fourthQuoter) + "</th>"
                    + "<th>" + x + "</th>"
                    + "<th>" + y + "</th>"
                    + "<th>" + r + "</th>"
                    + "</tr>");
        } else {
            getServletContext().getRequestDispatcher("/table.jsp").forward(req, resp);
        }
    }
}
