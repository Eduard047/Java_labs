import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book>collectionOfBooks;
    public Library(){this.collectionOfBooks=new ArrayList<>();}
    public void addNewBook(Book newBook){collectionOfBooks.add(newBook);}

    public void showAllBooks() {
        for (Book book : collectionOfBooks) {
            System.out.println("Book Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("ISBN: " + book.getIsbn());
            System.out.println("Publication Year: " + book.getYearOfPublication() + "\n");
        }
    }

    public List<Book> findBooksByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : collectionOfBooks) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public void removeBookByISBN (String isbn) {
        collectionOfBooks.removeIf(book -> book.getIsbn().equals(isbn));
    }
    public List<Book> getCollectionOfBooks(){return collectionOfBooks;}
}