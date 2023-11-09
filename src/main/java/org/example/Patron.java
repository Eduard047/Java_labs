package org.example;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String name;
    private String ID;
    public List<Item> borrowedItems;

    public Patron(String name, String ID) {
        this.name = name;
        this.ID = ID;
        borrowedItems = new ArrayList<>();
    }

    public void borrow(Item item) {
        if (!borrowedItems.contains(item)) {
            borrowedItems.add(item);
            item.borrowItem();
        }
    }

    public void returnItem(Item item) {
        if (borrowedItems.contains(item)) {
            borrowedItems.remove(item);
            item.returnItem();
        }
    }

    public String getName() {
        return this.name;
    }
}
