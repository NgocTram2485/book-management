/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book.management.repository;

import book.management.models.Account;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository extends Repository {

    public Account get(String username) {
        String sql = """
                     SELECT a.* FROM accounts a;
                     """;
        try {
            List<Account> accounts = new ArrayList<>();
            try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Account p = new Account();
                    p.parse(rs);
                    accounts.add(p);
                }
                stmt.close();
                conn.close();
            }
            if (accounts.isEmpty()) {
                return null;
            }
            return accounts.get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
