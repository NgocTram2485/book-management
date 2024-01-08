/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book.management.repository;

import book.management.models.Category;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository extends Repository {

    public List<Category> listAll() {
        String sql = """
                     SELECT c.* FROM categories c;
                     """;
        try {
            List<Category> categories = new ArrayList<>();
            try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Category category = new Category();
                    category.parse(rs);
                    categories.add(category);
                }
                stmt.close();
                conn.close();
            }
            return categories;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
