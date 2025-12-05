import database.DatabaseHelper;
import database.ProductDAO;
import models.Product;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;

public class Main extends JFrame {
    public static void main(String[] args) {



        ProductDAO p = new ProductDAO();
        DefaultTableModel tableModel = p.getAllProducts();


        JFrame frame = new JFrame("Inventory");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(true);

        Container c = frame.getContentPane();

        JLabel headerLabel = new JLabel(" Product Inventory", SwingConstants.CENTER); // Center the label
        headerLabel.setFont(new Font("Serif", Font.BOLD, 18));

        JTable productTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(productTable);

        c.add(headerLabel, BorderLayout.NORTH);


        c.add(scrollPane, BorderLayout.CENTER);

        frame.setSize(700, 400);
        // frame.pack();
        frame.setVisible(true);

//        Product product = new Product(4, "PC", "Electronics", 500, 20000, 30);
//        p.addProduct(product);



    }
}