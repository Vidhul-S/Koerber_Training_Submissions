package day2LabAssignment.bookStore;

import java.util.Scanner;

class BookStore {
    Book[] books;
    int n;
    public BookStore(){
        this.n=10;
        this.books = new Book[this.n];
    }
    public BookStore(Book[] books,int n){
        this.n = n;
        this.books = books;
    }
    void sell(String bookTitle, int noOfCopies) {

        int n = this.books.length;
        for (int i = 0; i < n; i++) {

            if (this.books[i].bookTitle.equals(bookTitle) && this.books[i].noOfCopies != 0) {

                this.books[i].noOfCopies -= noOfCopies;
            } else {

                System.out.println("Book not found");
            }
        }
    }

    void order(String ISBN,int noOfCopies){

        int c=0;
        for (int i = 0; i < n; i++) {

            if (this.books[i].ISBN.equals(ISBN) && this.books[i].noOfCopies != 0){

                c++;
                this.books[i].noOfCopies += noOfCopies;
            }
        }
        if(c==0){

            Scanner s = new Scanner(System.in);
            System.out.println("Enter book Title");
            String bookTitle = s.nextLine();
            System.out.println("Enter Author's name");
            String author = s.nextLine();
            //books [] = [this.books,new Book(bookTitle,author,ISBN,noOfCopies)]; can't be done in java
            Book [] booksCopy = new Book[n+1];
            for (int i = 0; i < n+1; i++) {
                if(i!=n) {
                    booksCopy [i] = this.books[i];
                }
                else{
                    booksCopy [i] = new Book(bookTitle,author,ISBN,noOfCopies);
                }
            }
            this.books = booksCopy;
        }
    }

    void display(){
        for (int i = 0; i < n; i++) {
            books[i].display();
        }
    }
}
