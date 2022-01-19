//package controller;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet("/")
//public class RedirectService extends HttpServlet {
//
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String uri = req.getRequestURI();
//        String conPath = req.getContextPath();
//        String com = uri.substring(conPath.length());
//
//        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html;charset=UTF-8");
//
//        String view = null;
//        switch (com) {
//            case "/":
//            case "/main":
//                view = "index.jsp";
//                break;
//            case "/managerMain":
//                view = "managerMain.jsp";
//                break;
//            case "/page02":
//                view = "page02.jsp";
//                break;
//            case "/page03":
//                view = "redirect:page03.jsp";
//                break;
//        }
//        if(view.startsWith("redirect:")) {
//            resp.sendRedirect(view.substring(9));
//        } else {
//            req.getRequestDispatcher(view).forward(req, resp);
//        }
//    }
//}
