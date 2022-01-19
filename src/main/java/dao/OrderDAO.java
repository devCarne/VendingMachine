package dao;

import dto.DrinkDTO;
import dto.OrderDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
            pstmt.setDate(3, order.getOrder_time());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
