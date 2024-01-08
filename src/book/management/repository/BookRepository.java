/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book.management.repository;

import book.management.models.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository extends Repository {

    public List<Book> listProduct() {
        String sql = """
                     SELECT b.id,
                            b.name, 
                            b.author,
                            b.category_id,
                            c.name,
                            b.publisher_id,
                            p.name,
                            b.price,
                            b.qty,
                            b.created_at,
                            b.updated_at
                     FROM books b
                              JOIN categories c on c.id = b.category_id
                              JOIN publishers p on p.id = b.publisher_id
                     WHERE b.status = 'active';
                     """;
        try {
            List<Book> books = new ArrayList<>();
            try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Book book = new Book();
                    book.parse(rs);
                    books.add(book);
                }
                stmt.close();
                conn.close();
            }
            return books;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> searchBook(String searchContent) {
        String sqlTemplate = """
                     SELECT b.id,
                            b.name,
                            b.author,
                            b.category_id,
                            c.name,
                            b.publisher_id,
                            p.name,
                            b.price,
                            b.qty,
                            b.created_at,
                            b.updated_at
                     FROM books b
                              JOIN categories c on c.id = b.category_id
                              JOIN publishers p on p.id = b.publisher_id
                     WHERE b.status = 'active'
                       AND (b.name LIKE ? OR b.author LIKE ? OR c.name LIKE ? OR p.name LIKE ?)
                     ORDER BY created_at DESC;
                     """;
        try {
            List<Book> books;
            try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sqlTemplate)) {
                searchContent = "%" + searchContent + "%";
                pstmt.setString(1, searchContent);
                pstmt.setString(2, searchContent);
                pstmt.setString(3, searchContent);
                pstmt.setString(4, searchContent);
                ResultSet rs = pstmt.executeQuery();
                books = new ArrayList<>();
                while (rs.next()) {
                    Book product = new Book();
                    product.parse(rs);
                    books.add(product);
                }
            }
            return books;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateBook(Book p) {
        String sqlTemplate = """
                     UPDATE books
                              SET name = ?,
                                  author = ?,
                                  price = ?,
                                  qty = ?,
                                  category_id = ?,
                                  publisher_id = ?,
                                  updated_at = NOW()
                              WHERE id = ?;
                     """;
        try {
            try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sqlTemplate)) {
                pstmt.setString(1, p.getName());
                pstmt.setString(2, p.getAuthor());
                pstmt.setDouble(3, p.getPrice());
                pstmt.setInt(4, p.getQty());
                pstmt.setInt(5, p.getCategoryId());
                pstmt.setInt(6, p.getPulisherId());
                pstmt.setInt(7, p.getId());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeBook(int id) {
        String sqlTemplate = """
                     UPDATE books
                              SET status = 'inactive'
                              WHERE id = ?;
                     """;
        try {
            try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sqlTemplate)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void createBook(Book p) {
        String sqlTemplate = """
                     INSERT INTO books(name, author, price, qty, category_id, publisher_id, status, avatar, created_at, updated_at)
                              VALUES (?, ?, ?, ?, ?, ?, "active", "", NOW(), NOW());
                     """;
        try {
            try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sqlTemplate)) {
                pstmt.setString(1, p.getName());
                pstmt.setString(2, p.getAuthor());
                pstmt.setInt(3, p.getPrice());
                pstmt.setInt(4, p.getQty());
                pstmt.setInt(5, p.getCategoryId());
                pstmt.setInt(6, p.getPulisherId());
                pstmt.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
