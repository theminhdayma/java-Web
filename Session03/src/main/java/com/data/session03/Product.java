package com.data.session03;

public class Product {
    private int id;
    private String productName;
    private double price;
    private String description;
    private int stock;

    public Product(int id, String productName, double price, String description, int stock) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    public int getId() { return id; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }
    public int getStock() { return stock; }

    public String getStatus() {
        return stock > 0 ? "Còn hàng" : "Hết hàng";
    }
}

