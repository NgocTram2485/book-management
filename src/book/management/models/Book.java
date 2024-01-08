/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book.management.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Book {

    private int id;

    private String name;

    private String author;

    private int categoryId;

    private String categoryName;

    private int pulisherId;

    private String publisherName;

    private int price;

    private int qty;

    private String createdAt;

    private String updatedAt;

    public void parse(ResultSet rs) {
        try {
            this.setId(rs.getInt(1));
            this.setName(rs.getString(2));
            this.setAuthor(rs.getString(3));
            this.setCategoryId(rs.getInt(4));
            this.setCategoryName(rs.getString(5));
            this.setPulisherId(rs.getInt(6));
            this.setPublisherName(rs.getString(7));
            this.setPrice(rs.getInt(8));
            this.setQty(rs.getInt(9));
            this.setCreatedAt(rs.getString(10));
            this.setUpdatedAt(rs.getString(11));
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Book() {
    }

    public Book(int id, String name, String author, int price, int qty, int categoryId, int pulisherId) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.categoryId = categoryId;
        this.pulisherId = pulisherId;
        this.price = price;
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getPulisherId() {
        return pulisherId;
    }

    public void setPulisherId(int pulisherId) {
        this.pulisherId = pulisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
