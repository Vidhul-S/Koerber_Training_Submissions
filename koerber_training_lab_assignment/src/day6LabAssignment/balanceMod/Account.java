package day6LabAssignment.balanceMod;

public class Account {
    private double balance;
    private String accountNo,accountHolderName;
    public Account(){}
    public Account(String accountNo,String accountHolderName,double balance){

        this.accountNo = accountNo;
        this.accountHolderName = accountHolderName;
        this.setBalance(balance);
    }
    private synchronized void setBalance(double amount){
        this.balance = amount;
    }
    public double getBalance() {
        return balance;
    }

    public synchronized void addAmount(double amount) {
        this.setBalance((this.balance+amount));
    }
    public synchronized void subtractAmount ( double amount){
        this.setBalance((this.balance-amount));
    }
}
