package org.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ECommercePlatform {

    private Map<Integer, User> users;
    private Map<Integer, Product> products;
    private Map<Integer, Order> orders;

    public ECommercePlatform() {
        this.users = new HashMap<>();
        this.products = new HashMap<>();
        this.orders = new HashMap<>();
    }

    public void addUser(User user) {
        this.users.put(user.getId(), user);
    }

    public void addProduct(Product product) {
        this.products.put(product.getId(), product);
    }

    public void createOrder(Order order) {
        order.validate();
        this.orders.put(order.getId(), order);

        for (Map.Entry<Product, Integer> entry : order.getOrderDetails().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            product.setStock(product.getStock() - quantity);
        }
    }

    public List<Product> getAvailableProducts() {
        List<Product> availableProducts = new ArrayList<>();

        for (Product product : this.products.values()) {
            if (product.getStock() > 0) {
                availableProducts.add(product);
            }
        }

        return availableProducts;
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();

        for (User user : this.users.values()) {
            users.add(user);
        }

        return users;
    }

    public List<Order> getOrders() {
        List<Order> orders = new ArrayList<>();

        for (Order order : this.orders.values()) {
            orders.add(order);
        }

        return orders;
    }

    public void updateProductStock(int productId, int quantity) {
        Product product = this.products.get(productId);

        if (product != null) {
            product.setStock(product.getStock() + quantity);
        }
    }
}
