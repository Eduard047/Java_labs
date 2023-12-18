package org.example;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Створення об'єктів продуктів
        Product product1 = new Product(1, "Product 1", 10.0);
        Product product2 = new Product(2, "Product 2", 20.0);

        // Створення об'єкта кошика
        Cart cart = new Cart();

        // Додавання продуктів до кошика
        cart.addProduct(product1);
        System.out.println("Додано продукт до кошика: " + product1.getName());

        cart.addProduct(product2);
        System.out.println("Додано продукт до кошика: " + product2.getName());

        // Видалення продукту з кошика
        cart.removeProduct(product1);
        System.out.println("Видалено продукт з кошика: " + product1.getName());

        // Створення замовлення на основі кошика
        Order order = new Order(1, cart);
        order.placeOrder();
        System.out.println("Замовлення розміщено");

        // Перевірка статусу замовлення
        System.out.println("Статус замовлення: " + order.getStatus());
    }
}


