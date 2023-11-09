package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void lendItemShouldLendItemToPatron() {
        Library library = new Library();
        Book book = new Book("Test Book", "001", "Test Author");
        Patron patron = new Patron("Test Patron", "100");

        library.registerPatron(patron);
        library.add(book);

        library.lendItem(patron, book);

        assertTrue(book.isBorrowed());
        assertTrue(patron.borrowedItems.contains(book));
    }
}
