package day2LabAssignment.employeePaySystem;

import java.util.ArrayList;

public class PaySystem {

    private ArrayList<Payable> payables;
    public PaySystem() {

        payables = new ArrayList<>();
    }
    public void addPayable(Payable payable) {

        payables.add(payable);
    }
    public void displayPayments() {

        for (Payable payable : payables) {

            payable.getPayment();
        }
    }
    public static void main(String[] args) {

        Employee emp1 = new Employee(1, "John", "Doe", 5000);
        Employee emp2 = new Employee(2, "Jane", "Smith", 4500);
        Invoice inv1 = new Invoice(101, "Software Development", 15000);
        Invoice inv2 = new Invoice(102, "Consulting Services", 8000);
        PaySystem paySystem = new PaySystem();
        paySystem.addPayable(emp1);
        paySystem.addPayable(emp2);
        paySystem.addPayable(inv1);
        paySystem.addPayable(inv2);
        paySystem.displayPayments();
    }
}
