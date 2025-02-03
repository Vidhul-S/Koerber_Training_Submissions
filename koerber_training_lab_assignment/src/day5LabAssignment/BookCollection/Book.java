package day5LabAssignment.BookCollection;


public class Book {

    private String bookTitle,author,ISBN;
    public Book(){}
    public Book(String ISBN, String bookTitle, String author) {

        this.bookTitle = bookTitle;
        this.author = author;
        this.ISBN = ISBN ;
    }

    public String getISBN() {

        return ISBN;
    }
    public String getBookTitle() {

        return bookTitle;
    }
    public String getAuthor() {

        return author;
    }
    void display(){

        System.out.print(this.toString());
    }
    public String toString(){

        StringBuilder sb = new StringBuilder();
        return sb.append(this.ISBN).append(":").append(this.bookTitle).append(":").append(this.author).toString();
    }
}
