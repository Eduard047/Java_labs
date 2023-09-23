import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class LibraryTest {

    @Test
    public void addNewBook() {
        Library library = new Library();
        Book book = new Book("Title", "Author", "978-0385472579", 2023);

        library.addNewBook(book);

        Assert.assertTrue(library.getCollectionOfBooks().contains(book));
    }

    @Test
    public void findBooksByTitle() {
        Library library = new Library();
        Book book1 = new Book("Title", "Author1", "978-0385472579", 2023);
        Book book2 = new Book("Title", "Author2", "978-0679417875", 2023);

        library.addNewBook(book1);
        library.addNewBook(book2);

        List<Book> result = library.findBooksByTitle("Title");

        Assert.assertEquals(2, result.size());
    }

    @Test
    public void removeBookByISBN() {
        Library library = new Library();
        Book book1 = new Book("Title1", "Author1", "978-0385472579", 2023);
        Book book2 = new Book("Title2", "Author2", "978-0679417875", 2023);

        library.addNewBook(book1);
        library.addNewBook(book2);

        library.removeBookByISBN("978-0385472579");

        Assert.assertFalse(library.getCollectionOfBooks().contains(book1));
    }
}