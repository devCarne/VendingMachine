package controller;

import service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/managerSignUp.do")
public class ManagerSignUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html;charset=utf-8");

        ManagerService service = new ManagerService();

        if (service.signUp(req.getParameter("ID"), req.getParameter("PW"), req.getParameter("name"))) {
            out.println("<script>alert('등록에 성공했습니다.'); window.location.href='managerMain.jsp'</script>");
        } else {
            out.println("<script>alert('등록에 실패했습니다.'); window.location.href='managerMain.jsp'</script>");
        }
    }
}
