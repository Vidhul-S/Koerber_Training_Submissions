package day3_4LabAssignment.bookStore;

import java.io.BufferedWriter;
import java.io.FileWriter;

class Book {

    String bookTitle,author,ISBN;
    int noOfCopies;
    double price;
    public Book(){}
    public Book( String ISBN,String bookTitle, String author, int noOfCopies,double price) {

        this.bookTitle = bookTitle;
        this.author = author;
        this.ISBN = ISBN ;
        this.noOfCopies = noOfCopies;
        this.price = price;
    }

    public String getISBN() {

        return ISBN;
    }
    public double getPrice() {

        return price;
    }
    public String getBookTitle() {

        return bookTitle;
    }
    public int getNoOfCopies() {

        return noOfCopies;
    }
    public String getAuthor() {

        return author;
    }
    void display(){

        System.out.print(this.toString());
    }
    public String toString(){

        StringBuilder sb = new StringBuilder();
        return sb.append(this.ISBN).append(":").append(this.bookTitle).append(":").append(this.author).append(":").append(this.noOfCopies).append(":").append(this.price).toString();
    }
}
