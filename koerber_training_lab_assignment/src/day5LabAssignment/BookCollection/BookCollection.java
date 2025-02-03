package day5LabAssignment.BookCollection;

import java.util.*;

import static java.util.Arrays.compare;


public class BookCollection extends Book{
    List<Book> bookCollection = new ArrayList<>();
    void display(HashSet<Book> books){
        for (Book book:books){
            book.display();
        }
    }
    int hasBook(Book book){

        for(Book b:this.bookCollection){
            if((book.getBookTitle()
                    .compareTo(b.getBookTitle())==0)||(book.getAuthor()
                    .compareTo(b.getAuthor())==0)){

                return 0;
            }
        }
        return -1;
    }
    void sort(){
        Collections.sort(bookCollection, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                int c = b1.getBookTitle().compareTo(b2.getBookTitle());
                if (c != 0) {
                    return c;
                }
                return b1.getAuthor().compareTo(b2.getAuthor());
            }
        });
    }
    public static void main(String[] args) {
        // Create some books
        Book book1 = new Book("ISBN001", "Java in depth", "John Smith");
        Book book2 = new Book("ISBN002", "Python Essentials", "Jane Doe");
        Book book3 = new Book("ISBN003", "C++ Fundamentals", "Alice Johnson");
        Book book4 = new Book("ISBN004", "Java in depth", "Michael Brown");

        // Create a BookCollection
        BookCollection myCollection = new BookCollection();
        myCollection.bookCollection.add(book1);
        myCollection.bookCollection.add(book2);
        myCollection.bookCollection.add(book3);
        myCollection.bookCollection.add(book4);

        // Check if the collection contains "Java in depth"
        Book searchBook = new Book(null, "Java in depth", null);
        int hasBook = myCollection.hasBook(searchBook);
        if (hasBook == 0) {
            System.out.println("You own the book 'Java in depth'.");
        } else {
            System.out.println("You don't own the book 'Java in depth'.");
        }

        // Sort the book collection
        myCollection.sort();

        // Display the sorted book collection
        System.out.println("\nSorted Book Collection:");
        for (Book book : myCollection.bookCollection) {
            System.out.println(book);
        }
    }
}
