package controller;

import dto.BasketDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/basketInsert.do")
public class BasketInsert extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        BasketDTO basket = (BasketDTO) session.getAttribute("basket");
        HashMap<String, Integer> orders = basket.getSelection();
        orders.put(req.getParameter("code"), Integer.parseInt(req.getParameter("quantity")));
        resp.sendRedirect("customerDrinkList.jsp");
    }
}

