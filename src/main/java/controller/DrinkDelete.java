package controller;

import service.DrinkService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/drinkDelete.do")
public class DrinkDelete extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        DrinkService service = new DrinkService();

        if (service.delete(req.getParameter("code"))) {
            out.println("<script>alert('삭제에 성공했습니다.'); window.location.href='managerMain.jsp'</script>");
        } else {
            out.println("<script>alert('삭제에 실패했습니다.'); window.location.href='managerMain.jsp'</script>");
        }
    }
}
