package org.example;

import java.util.List;
import java.util.ArrayList;

public class Library implements IManageable {
    List<Item> items;
    List<Patron> patrons;

    public Library() {
        items = new ArrayList<>();
        patrons = new ArrayList<>();
    }

    public void registerPatron(Patron patron) {
        patrons.add(patron);
    }

    public void lendItem(Patron patron, Item item) {
        if (patrons.contains(patron) && items.contains(item) && !item.isBorrowed()) {
            patron.borrow(item);
        }
    }

    public void returnItem(Patron patron, Item item) {
        if (patrons.contains(patron) && items.contains(item) && item.isBorrowed()) {
            patron.returnItem(item);
        }
    }

    @Override
    public void add(Item item) {
        items.add(item);
    }

    @Override
    public void remove(Item item) {
        items.remove(item);
    }

    @Override
    public void listAvailable() {
        System.out.println("Список доступних предметів:");
        for (Item item : items) {
            if (!item.isBorrowed()) {
                System.out.println(item.getTitle());
            }
        }
    }

    @Override
    public void listBorrowed() {
        System.out.println("Список взятих предметів та їхніх читачів:");
        for (Item item : items) {
            if (item.isBorrowed()) {
                for (Patron patron : patrons) {
                    if (patron.borrowedItems.contains(item)) {
                        System.out.println(item.getTitle() + " взято читачем " + patron.getName());
                    }
                }
            }
        }
    }
}
