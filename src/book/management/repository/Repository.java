/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book.management.repository;

import java.sql.*;

public abstract class Repository {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/book_management";

    private static final String USER_NAME = "root";

    private static final String PASSWORD = "secret";

    protected static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");  
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("connect successfully!");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("connect failure!");
        }
        return conn;
    }
}
