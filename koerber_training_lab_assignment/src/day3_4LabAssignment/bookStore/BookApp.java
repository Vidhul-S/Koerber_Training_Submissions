package day3_4LabAssignment.bookStore;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

class BookApp extends Book{

    static class NotSufficientBookException extends Exception{}
    LinkedList <Book> books = new LinkedList<>();
    public BookApp() {
        try (BufferedReader fi = new BufferedReader(new FileReader("books.txt"));) {
            String line;
            while ((line = fi.readLine()) != null) {
                String[] parts = line.split(":");
                String ISBN = parts[0];
                String bookTitle = parts[1];
                String author = parts[2];
                int noOfCopies = Integer.parseInt(parts[3]);
                double price = Double.parseDouble(parts[4]);
                this.books.add(new Book(ISBN, bookTitle, author, noOfCopies, price));
            }
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }
    void sellBook(String bookTitle, int noOfCopies) throws Exception {

        for (Book book : books) {

            if (book.bookTitle.equals(bookTitle) && book.noOfCopies != 0) {

                book.noOfCopies -= noOfCopies;
                System.out.println("Collect amount" + book.price);
            } else {

                Exception e = new NotSufficientBookException();
                System.out.println("Book not found");
                throw (e);
            }
        }
    }
    void purchaseBook(String ISBN,int noOfCopies){

        int c=0;
        for (Book book : this.books) {

            if (book.ISBN.equals(ISBN) && book.noOfCopies != 0){

                c++;
                book.noOfCopies += noOfCopies;
            }
        }
        if(c==0){

            Scanner s = new Scanner(System.in);
            System.out.println("Enter book Title");
            String bookTitle = s.nextLine();
            System.out.println("Enter Author's name");
            String author = s.nextLine();
            System.out.println("Enter the book's price");
            double price = s.nextDouble();
            this.books.add(new Book(ISBN,bookTitle,author,noOfCopies,price));
        }
    }
    void searchBook(String ISBN){
        boolean c=false;
        for(Book book: this.books){
            if(book.getISBN()==ISBN){
                c=true;
                System.out.println("Book found");
                book.display();
            }
        }
        if(!c){
            System.out.println("Book Not Found");
        }
    }
}
