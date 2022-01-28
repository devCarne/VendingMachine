package controller;

import dao.ManagerDAO;
import service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/IdCheck.do")
public class ManagerIdCheck extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        ManagerService service = new ManagerService();
        String reqID = req.getParameter("id");

        if (reqID.equals((""))) {
            out.print("no");
        } else {
            if (service.idCheck(reqID)) {
                out.print("no");
            } else {
                out.print("yes");
            }
        }
    }
}
