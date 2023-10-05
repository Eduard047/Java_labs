package org.example;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product(1, "Product A", 10.0);
        Product product2 = new Product(2, "Product B", 15.0);

        Cart cart = new Cart();
        cart.addProduct(product1);
        cart.addProduct(product2);

        List<Product> productsInCart = cart.getProducts();
        System.out.println("Products in the cart:");
        for (Product product : productsInCart) {
            System.out.println(product.getName() + " - $" + product.getPrice());
        }

        Order order = new Order(1, new ArrayList<>(productsInCart));
        order.setStatus("Shipped");

        System.out.println("Order status: " + order.getStatus());
    }
}

