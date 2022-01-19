package controller;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;
import service.DrinkService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/drinkUpdate.do")
public class DrinkUpdate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        
        String filePath = getServletContext().getRealPath("images");

        MultipartRequest multi = new MultipartRequest(req, filePath, 5 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
        DrinkService service = new DrinkService();

        if (service.update(multi)) {
            out.println("<script>alert('변경에 성공했습니다.'); window.location.href='managerMain.jsp'</script>");
        } else {
            out.println("<script>alert('변경에 실패했습니다.'); window.location.href='managerMain.jsp'</script>");
        }
    }
}
