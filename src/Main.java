import java.util.List;
public class Main {
    public static void main(String[] args) {

        Book book1 = new Book("Герой нашого часу", "Лесь Подерв'янський", "978-1563890132", 1840);
        Library library = getLibrary(book1);

        System.out.println("Наявні в бібліотеці книги:\n");
        library.showAllBooks();

        String searchTitle = "Тіні забутих предків";
        System.out.println("\nПошук книги за назвою '" + searchTitle + "':");
        List<Book> searchResult = library.findBooksByTitle(searchTitle);
        for (Book book : searchResult) {
            System.out.println("\nНазва: " + book.title() + "\nАвтор: " + book.author() +
                    "\nISBN: " + book.isbn() + "\nРік видання: " + book.yearOfPublication() + "\n");
        }

        String isbnToDelete = "978-0735611313";
        System.out.println("\nВидалення книги з ISBN '" + isbnToDelete + "':");
        library.removeBookByISBN(isbnToDelete);

        System.out.println("\nСписок книг після видалення:");
        library.showAllBooks();
    }

    private static Library getLibrary(Book book1) {
        Book book2 = new Book("Тіні забутих предків", "Михайло Коцюбинський", "978-0735611313", 1912);
        Book book3 = new Book("Подвійний Леон", "Юрій Іздрик", "978-0684856094", 2000);
        Book book4 = new Book("Залишенець. Чорний ворон", "Василь Шкляр", "978-0679746041",  2009);
        Book book5 = new Book("Одержима", "Леся Українка", "978-0316067937", 1902);
        Book book6 = new Book("Феномен доби", "Василь Стус", "978-0451526342", 1970);
        Book book7 = new Book("Місто", "Валер'ян Підмогильний", "978-0061120084", 1928);
        Book book8 = new Book("Записки кирпатого Мефістофеля", "Володимир Винниченко", "978-0142437014", 1917);
        Book book9 = new Book("De libertate", "Григорій Сковорода", "978-0743273565", 1757);
        Book book10 = new Book("Енеїда", "Іван Котляревський", "978-1503286404", 1798);

        Library library = new Library();

        library.addNewBook(book1);
        library.addNewBook(book2);
        library.addNewBook(book3);
        library.addNewBook(book4);
        library.addNewBook(book5);
        library.addNewBook(book6);
        library.addNewBook(book7);
        library.addNewBook(book8);
        library.addNewBook(book9);
        library.addNewBook(book10);
        return library;
    }
}
