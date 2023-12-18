package org.example;



public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book fantasyBook = new Book("Fantasy World", "123", "Author1");
        Book sciFiBook = new Book("Space Adventures", "124", "Author2");
        DVD actionDVD = new DVD("Action Thriller", "456", 120);
        DVD comedyDVD = new DVD("Laugh Out Loud", "457", 90);
        Patron reader1 = new Patron("John Doe", "1001");
        Patron reader2 = new Patron("Jane Smith", "1002");

        library.add(fantasyBook);
        library.add(sciFiBook);
        library.add(actionDVD);
        library.add(comedyDVD);

        library.registerPatron(reader1);
        library.registerPatron(reader2);

        library.lendItem(reader1, fantasyBook);
        library.lendItem(reader1, actionDVD);
        library.returnItem(reader1, fantasyBook);
        library.returnItem(reader1, actionDVD);
        library.listAvailable();
        library.listBorrowed();
    }
}

