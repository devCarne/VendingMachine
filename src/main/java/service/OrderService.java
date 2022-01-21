package service;

import dao.OrderDAO;
import dto.BasketDTO;
import dto.OrderDTO;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderService {

    OrderDAO dao = new OrderDAO();

    public void order(BasketDTO basket) {
        HashMap<String, Integer> selection = basket.getSelection();

        selection.forEach((K, V) -> {
            OrderDTO order = new OrderDTO(K, V, basket.getTimestamp());
            dao.insert(order);
        });
    }

    public ArrayList<OrderDTO> getList() {
        return dao.getList();
    }
}