package day2LabAssignment.bank;

public class CurrentAccount extends Account{

    int tradeLicenseNumber;
    double overDraft;
    public CurrentAccount(){}
    public CurrentAccount(int tradeLicenseNumber,double overDraft){

        this.tradeLicenseNumber = tradeLicenseNumber;
        this.overDraft = overDraft;
    }

    @Override
    public boolean withdraw(double amount){

        if(super.accountBalance+this.overDraft<=amount){

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
