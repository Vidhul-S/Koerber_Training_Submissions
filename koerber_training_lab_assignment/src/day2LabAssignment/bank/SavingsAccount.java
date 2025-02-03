package day2LabAssignment.bank;

public class SavingsAccount extends Account{

    static final int intrest = 5;
    double maxWithdrawal;
    public SavingsAccount(String name,int accountNumber,double accountBalance){

        new Account(name,accountNumber,accountBalance);
        this.maxWithdrawal = accountBalance;
    }
    @Override
    public double getBalance(){
        return super.accountBalance+super.accountBalance*intrest;
    }
    @Override
    public boolean withdraw(double amount){

        if(amount <= this.maxWithdrawal){

            super.accountBalance -= amount;
        }
        else if(amount<0){

            System.out.println("Invalid amount");
        }
        else{

            System.out.println("Insufficent balance");
        }
        return false;
    }
}
