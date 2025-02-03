package day2LabAssignment.bank;

import java.util.Scanner;

public class BankingSystem {

    private Account account;
    public static void main(String[] args) {

        BankingSystem bankingSystem = new BankingSystem();
        bankingSystem.run();
    }

    public void run() {

        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the Banking System!");
        createAccount(s);

        while (true) {

            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            int choice = s.nextInt();
            switch (choice) {

                case 1:
                    deposit(s);
                    break;
                case 2:
                    withdraw(s);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting the Banking System. Have a great day!");
                    s.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void createAccount(Scanner s) {
        System.out.println("Create a new account:");
        System.out.println("Choose account type:");
        System.out.println("1. Saving Account");
        System.out.println("2. Current Account");

        int accountType = s.nextInt();
        s.nextLine(); // Consume newline

        if (accountType == 1) {
            // Create Savings Account
            System.out.print("Enter your name: ");
            String name = s.nextLine();

            System.out.print("Enter account number: ");
            int accountNumber = s.nextInt();

            System.out.print("Enter initial balance: ");
            double accountBalance = s.nextDouble();

            account = new SavingsAccount(name, accountNumber, accountBalance);
        } else if (accountType == 2) {
            // Create Current Account
            System.out.print("Enter trade license number: ");
            int tradeLicenseNumber = s.nextInt();

            System.out.print("Enter overdraft limit: ");
            double overDraft = s.nextDouble();

            account = new CurrentAccount(tradeLicenseNumber, overDraft);
        } else {
            System.out.println("Invalid account type. Please start again.");
            createAccount(s);
        }

        System.out.println("Account created successfully!");
        System.out.println("Account Type: " + (account instanceof SavingsAccount ? "Savings Account" : "Current Account"));
        System.out.println("Initial Balance: " + account.getBalance());
    }

    private void deposit(Scanner s) {
        System.out.print("Enter the amount to deposit: ");
        double amount = s.nextDouble();
        if (amount > 0) {
            account.deposit(amount);
            System.out.println("Deposit successful! New balance: " + account.getBalance());
        } else {
            System.out.println("Invalid amount. Deposit failed.");
        }
    }
    private void withdraw(Scanner s){
        System.out.print("Enter the amount to withdraw: ");
        double amount = s.nextDouble();
        account.withdraw(amount);
    }


    private void checkBalance() {
        System.out.println("Current balance: " + account.getBalance());
    }

}
