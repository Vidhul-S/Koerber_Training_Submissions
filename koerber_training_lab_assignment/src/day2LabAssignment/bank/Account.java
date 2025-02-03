package day2LabAssignment.bank;

public class Account {

    String name;
    int accountNumber;
    double accountBalance;
    public Account(){}
    public Account(String name,int accountNumber,double accountBalance){

        this.name = name;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }
    public void deposit(double amount){

        this.accountBalance += amount;
    }
    public double getBalance(){

        return this.accountBalance;
    }
    public boolean withdraw(double amount) {

        if (amount <= this.accountBalance) {

            this.accountBalance -= amount;
        }
        else if (amount < 0) {

            System.out.println("Invalid amount");
        }
        else {

            System.out.println("Insufficent balance");
        }
        return true;
    }
}
