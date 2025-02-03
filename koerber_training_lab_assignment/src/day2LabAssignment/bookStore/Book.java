package day2LabAssignment.bookStore;

class Book {

    String bookTitle,author,ISBN;
    int noOfCopies;

    public Book(){}
    public Book(String bookTitle, String author, String ISBN, int noOfCopies) {

        this.bookTitle = bookTitle;
        this.author = author;
        this.ISBN = ISBN ;
        this.noOfCopies = noOfCopies;
    }
    void display(){

        System.out.println(this.bookTitle+"-"+this.author+"-"+this.ISBN+"-"+this.noOfCopies);
    }
}
