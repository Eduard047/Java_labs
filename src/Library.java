import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book>collectionOfBooks;
    public Library(){this.collectionOfBooks=new ArrayList<>();}
    public void addNewBook(Book newBook){collectionOfBooks.add(newBook);}

    public void showAllBooks() {
        for (Book book : collectionOfBooks) {
            System.out.println("Book Title: " + book.title());
            System.out.println("Author: " + book.author());
            System.out.println("ISBN: " + book.isbn());
            System.out.println("Publication Year: " + book.yearOfPublication() + "\n");
        }
    }

    public List<Book> findBooksByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : collectionOfBooks) {
            if (book.title().equalsIgnoreCase(title)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public void removeBookByISBN (String isbn) {
        collectionOfBooks.removeIf(book -> book.isbn().equals(isbn));
    }
    public List<Book> getCollectionOfBooks(){return collectionOfBooks;}
}