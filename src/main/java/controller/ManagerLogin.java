package controller;

import dto.ManagerDTO;
import service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/managerLogin.do")
public class ManagerLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        ManagerService service = new ManagerService();

        ManagerDTO manager = service.login(req.getParameter("ID"), req.getParameter("PW"));

        if (manager == null) {
            out.println("<script>alert('아이디가 잘못되었습니다.'); history.go(-1)</script>");
        } else if (!manager.getPW().equals(req.getParameter("PW"))) {
            out.println("<script>alert('비밀번호가 잘못되었습니다.'); history.go(-1)</script>");
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("managerID", manager.getID());
            session.setAttribute("managerName", manager.getName());
            resp.sendRedirect("managerMain.jsp");
        }
    }
}
