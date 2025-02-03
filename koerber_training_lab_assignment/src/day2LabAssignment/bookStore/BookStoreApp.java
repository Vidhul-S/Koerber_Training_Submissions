package day2LabAssignment.bookStore;
public class BookStoreApp{
    public static void main(String[] args){
        BookStore bs = new BookStore();

        bs.order("12345", 5);
        bs.order("12345", 3);

        System.out.println("Books available in the store:");
        bs.display();

        System.out.println("\nSelling books...");
        bs.sell("12345", 2);
        bs.sell("99999", 1);

        System.out.println("\nBooks available in the store after selling:");
        bs.display();
    }
}

