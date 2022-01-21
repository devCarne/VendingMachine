package dao;

import dto.DrinkDTO;
import dto.OrderDTO;

import java.sql.*;
import java.util.ArrayList;

public class OrderDAO {

    public Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            return DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "system", "1234");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean insert(OrderDTO order) {
        String sql = "INSERT INTO TBL_ORDERS VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
            pstmt.setString(1, order.getCode());
            pstmt.setInt(2, order.getQuantity());
            pstmt.setTimestamp(3, order.getOrder_time());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<OrderDTO> getList() {
        String sql = "SELECT * FROM TBL_ORDERS";
        ArrayList<OrderDTO> orderList = new ArrayList<>();

        try (Statement statement = getConnection().createStatement(); ResultSet rs = statement.executeQuery(sql)){
            while (rs.next()) {
                OrderDTO order = new OrderDTO(
                        rs.getString("CODE"),
                        rs.getInt("QUANTITY"),
                        rs.getTimestamp("ORDER_TIME")
                );
                orderList.add(order);
            }
            return orderList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
