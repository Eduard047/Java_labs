public class Book {
    private String title;
    private String author;
    private String isbn;
    private int yearOfPublication;


    public Book(String title,String author, String isbn, int yearOfPublication){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.yearOfPublication= yearOfPublication;
    }

    public String getTitle(){return this.title;}
    public String getAuthor(){return this.author;}
    public String getIsbn(){return this.isbn;}

    public int getYearOfPublication(){return this.yearOfPublication;}

}