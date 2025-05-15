package com.data.session04.Bai9;

public class Seat {
    private String id;
    private String name;
    private double price;
    private boolean booked;

    public Seat(String id, String name, double price, boolean booked) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.booked = booked;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBooked() {
        return booked;
    }
}
