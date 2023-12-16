package org.example;

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

        System.out.println("Доступні товари:");
        for (Product product : platform.getAvailableProducts()) {
            System.out.println(product);
        }

        System.out.println("Користувачі:");
        for (User user : platform.getUsers()) {
            System.out.println(user);
        }

        System.out.println("Замовлення:");
        for (Order order : platform.getOrders()) {
            System.out.println(order);
        }
    }
}
