package com.data.session03;

public class Order {
    private String product;
    private int quantity;
    private double pricePerUnit;

    public Order(String product, int quantity, double pricePerUnit) {
        this.product = product;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public double calculateTotal() {
        return quantity * pricePerUnit;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }
}

