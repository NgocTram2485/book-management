/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book.management.repository;

import book.management.models.Publisher;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PublisherRepository extends Repository {

    public List<Publisher> listAll() {
        String sql = """
                     SELECT p.* FROM publishers p;
                     """;
        try {
            List<Publisher> publishers = new ArrayList<>();
            try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Publisher p = new Publisher();
                    p.parse(rs);
                    publishers.add(p);
                }
                stmt.close();
                conn.close();
            }
            return publishers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
