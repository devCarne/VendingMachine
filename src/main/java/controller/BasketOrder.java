package controller;

import dto.BasketDTO;
import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/basketOrder.do")
public class BasketOrder extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        BasketDTO basket = (BasketDTO) session.getAttribute("basket");

        OrderService service = new OrderService();
        service.order(basket);

        session.removeAttribute("basket");
        resp.sendRedirect("index.jsp");
    }
}
