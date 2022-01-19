package dao;

import dto.DrinkDTO;

import java.sql.*;
import java.util.ArrayList;

public class DrinkDAO {

    public Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            return DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "system", "1234");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean insert(DrinkDTO drink) {
        String sql = "INSERT INTO TBL_DRINK VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
            pstmt.setString(1, drink.getCode());
            pstmt.setString(2, drink.getName());
            pstmt.setInt(3, drink.getPrice());
            pstmt.setInt(4, drink.getStock());
            pstmt.setString(5, drink.getImg());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<DrinkDTO> getList() {
        String sql = "SELECT * FROM TBL_DRINK";
        ArrayList<DrinkDTO> drinkList = new ArrayList<>();

        try (Statement statement = getConnection().createStatement(); ResultSet rs = statement.executeQuery(sql)){
            while (rs.next()) {
                DrinkDTO drink = new DrinkDTO(
                        rs.getString("CODE"),
                        rs.getString("NAME"),
                        rs.getInt("PRICE"),
                        rs.getInt("STOCK"),
                        rs.getString("IMG")
                );
                drinkList.add(drink);
            }
            return drinkList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public DrinkDTO getDrink(String code) {
        String sql = "SELECT * FROM TBL_DRINK WHERE CODE = '" + code + "'";
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            rs.next();
            return new DrinkDTO(
                    rs.getString("CODE"),
                    rs.getString("NAME"),
                    rs.getInt("PRICE"),
                    rs.getInt("STOCK"),
                    rs.getString("IMG")
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean update(DrinkDTO drink) {
        String sql = "UPDATE TBL_DRINK SET NAME = ?, PRICE = ?, STOCK = ?, IMG =? WHERE CODE = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, drink.getName());
            ps.setInt(2, drink.getPrice());
            ps.setInt(3, drink.getStock());
            ps.setString(4, drink.getImg());
            ps.setString(5, drink.getCode());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String code) {
        String sql = "DELETE FROM TBL_DRINK WHERE CODE = '" + code + "'";
        try (Statement statement = getConnection().createStatement()){
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
