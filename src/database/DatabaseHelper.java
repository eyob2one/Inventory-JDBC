package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {

    private static final String URL = "jdbc:mysql://localhost:3306/inventory?useSSL=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "root";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, user, password);
        } catch (SQLException e) {
            System.out.println("Database connection error");
            return null;
        }
    }


    public static void initializeDatabase() {
        String productTable = "CREATE TABLE IF NOT EXISTS products(" +
                "id int primary key auto_increment," +
                "name text not null," +
                "category text," +
                "price real," +
                "low_stock_threshold inT" + ")";

//        String customerTable = "CREATE TABLE IF NOT EXISTS customers(" +
//                "customer_id int primary key auto_increment," +
//                "first_name text not null," +
//                "last_name text" +
//                "transaction_id text not null";
//
//        String supplierTable = "CREATE TABLE IF NOT EXISTS suppliers("+
//                "supplier_id int primary key auto_increment,"+
//                "compnay_name text not null"+
//                "transaction_id text not null";

        try (Connection conn = getConnection()) {
            assert conn != null;
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(productTable);
                System.out.println("Database initialized");
            }
        } catch (SQLException e) {
            System.out.println("Error creating tables: " + e.getMessage());
        }
    }
}
