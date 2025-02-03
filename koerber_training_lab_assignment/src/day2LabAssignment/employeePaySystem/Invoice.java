package day2LabAssignment.employeePaySystem;

public class Invoice implements Payable {

    private int invoiceID;
    private String description;
    private double amount;
    public Invoice(int invoiceID, String description, double amount) {

        this.invoiceID = invoiceID;
        this.description = description;
        this.amount = amount;
    }
    public String toString() {

        return "Invoice[ID=" + this.invoiceID + ", Description=" + this.description + ", Amount=" + this.amount + "]";
    }
    public void getPayment() {
        System.out.println("Invoice Payment Info:");
        System.out.println(this.toString());
        System.out.println("Total Payment: " + this.amount);
    }
}
