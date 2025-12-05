package database;

import models.Product;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.PreparedStatement;

public class  ProductDAO {

    public void addProduct(Product p) {
        String sql = "INSERT INTO products (name, category, quantity, price, low_stock_threshold) " +
                "VALUES (?,?,?,?,?)";
        try (Connection conn = DatabaseHelper.getConnection()) {
            assert conn != null;
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, p.getName());
                pstmt.setString(2, p.getCategory());
                pstmt.setInt(3, p.getQuantity());
                pstmt.setDouble(4, p.getPrice());
                pstmt.setInt(5, p.getLowStockThreshold());

                int rows = pstmt.executeUpdate();

            }
        } catch(SQLException e) {
            System.out.println("Error adding product: " + e.getMessage());
        }
    }

    public DefaultTableModel getAllProducts() {
        String sql = "SELECT * FROM products";
        DefaultTableModel dtm = new DefaultTableModel();

        try (Connection conn = DatabaseHelper.getConnection()) {
            assert conn != null;
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                ResultSetMetaData rm = rs.getMetaData();
                Object[] row = new Object[rm.getColumnCount()];

                for(int i=1; i<=rm.getColumnCount(); i++){
                    dtm.addColumn(rm.getColumnLabel(i));
                }

                while (rs.next()) {

                    for(int i = 1; i<= rm.getColumnCount(); i++) {
                        row[i-1]= rs.getObject(i);
                    }
                    dtm.addRow(row);

//                    String data = rs.getInt("id") + " | " +
//                            rs.getString("name") + " | " +
//                            rs.getString("category") + " | " +
//                            rs.getInt("quantity") + " | " +
//                            rs.getDouble("price");
//                    productList.add(data);
                }

            }
        } catch (SQLException e) {
            System.out.println("Error fetching products.");
        }
        return dtm;
    }

    public boolean updateProduct(Product p) {
        String sql = "ALTER TABLE products UPDATE name = ?, quantity = ?, price = ? WHERE id = ?";

        try(Connection conn = DatabaseHelper.getConnection()){
            assert conn != null;
            try(PreparedStatement pstmt = conn.prepareStatement(sql)){

                pstmt.setString(1, p.getName());
                pstmt.setInt(2, p.getQuantity());
                pstmt.setDouble(3, p.getPrice());
                pstmt.setInt(4, p.getId());

                int rows = pstmt.executeUpdate();
                return rows > 0;

            }
        } catch (SQLException e) {
            System.out.println("Error updating product.");
            return false;
        }
    }

    public boolean deleteProduct(int id) {
        String sql = "DELETE FROM products WHERE id = ?";

        try(Connection conn = DatabaseHelper.getConnection()){
            assert conn != null;
            try(PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setInt(1, id);
                int rows = pstmt.executeUpdate();
                return rows > 0;
            }
        } catch(SQLException e) {
            System.out.println("Error deleting product");
            return false;
        }
    }

    public String searchProductByID(int id){
        String sql = "select * from products where id = ?";
        StringBuilder data = new StringBuilder();

        try(Connection conn = DatabaseHelper.getConnection()){
            assert conn != null;
            try(PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setInt(1,id);

                try(ResultSet rs = pstmt.executeQuery()){

                    ResultSetMetaData rm = rs.getMetaData();

                    if(rs.next()){
                        for(int i = 1; i<= rm.getColumnCount(); i++) {
                            Object columnValue = rs.getObject(i);

                            data.append(columnValue);

                            if (i < rm.getColumnCount()) {
                                data.append(" | ");
                            }
                        }
                        return data.toString();
                    }
                }
            }


        } catch(SQLException e) {
            System.out.println("Error finding the product with ID " + id);
        }
        return "";
    }

}
