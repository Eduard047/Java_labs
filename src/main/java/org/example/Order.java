package org.example;

import java.util.List;

public class Order {
    private int orderId;
    private Cart cart;
    private String status;

    public Order(int orderId, Cart cart) {
        this.orderId = orderId;
        this.cart = cart;
        this.status = "В обробці";
    }

    public double getTotalPrice() {
        List<Product> products = cart.getProducts();
        double totalPrice = 0.0;

        for (Product product : products) {
            totalPrice += product.getPrice();
        }

        return totalPrice;
    }

    public void placeOrder() {
        cart.placeOrder();
        this.status = "Виконано";
    }

    public String getStatus() {
        return status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
