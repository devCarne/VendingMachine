package dao;

import dto.ManagerDTO;

import java.sql.*;

public class ManagerDAO {

    public Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            return DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "system", "1234");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ManagerDTO login(String ID, String PW) {

        String sql = "SELECT * FROM tbl_drink_manager WHERE ID = '" + ID + "'";
        try (Statement statement = getConnection().createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            rs.next();
            return new ManagerDTO(rs.getString("ID"), rs.getString("PW"), rs.getString("NAME"));
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean signUp(ManagerDTO manager) {

        String sql = "INSERT INTO tbl_drink_manager VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
            pstmt.setString(1, manager.getID());
            pstmt.setString(2, manager.getPW());
            pstmt.setString(3, manager.getName());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isID_Exist(String ID) {

        String sql = "SELECT * FROM tbl_drink_manager WHERE ID = '" + ID + "'";
        try (Statement statement = getConnection().createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            rs.next();
            String result = rs.getString("ID");
            return result != null;
        } catch (SQLException e) {
            return false;
        }
    }
}
