package org.example;

import java.util.Comparator;
import java.util.List;

public class ECommerceDemo {

    public static void main(String[] args) {
        ECommercePlatform platform = new ECommercePlatform();

        User user1 = new User(1, "Andrew Davies");
        User user2 = new User(2, "Andrew Davies");
        platform.addUser(user1);
        platform.addUser(user2);

        Product product1 = new Product(1, "IPhone 13", 1000.0, 100);
        Product product2 = new Product(2, "MacBook Pro", 2000.0, 50);
        platform.addProduct(product1);
        platform.addProduct(product2);

        user1.addProductToCart(product1, 2);
        user2.addProductToCart(product2, 1);

        platform.createOrder(new Order(1, user1.getId(), user1.getCart(), 2000.0));
        platform.createOrder(new Order(2, user2.getId(), user2.getCart(), 2000.0));


// Виводимо список доступних товарів, відсортованих за назвою
        System.out.println("Доступні товари, відсортовані за назвою:");
        List<Product> products = platform.getAvailableProducts();
        products.sort(Comparator.comparing(Product::getName));
        for (Product product : products) {
            System.out.println(product);
        }

// Виводимо список доступних товарів, відсортованих за запасами
        System.out.println("Доступні товари, відсортовані за запасами:");
        products.sort(Comparator.comparing(Product::getStock));
        for (Product product : products) {
            System.out.println(product);
        }

// Виводимо список доступних товарів, відсортованих за ціною
        System.out.println("Доступні товари, відсортовані за ціною:");
        products.sort(Comparator.comparing(Product::getPrice));
        for (Product product : products) {
            System.out.println(product);
        }
    }
}