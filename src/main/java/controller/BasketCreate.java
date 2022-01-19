package controller;

import dto.BasketDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/createBasket.do")
public class BasketCreate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BasketDTO basket = new BasketDTO();

        HttpSession session = req.getSession();
        session.setAttribute("basket", basket);

        resp.sendRedirect("customerDrinkList.jsp");
    }
}
