package day6LabAssignment.balanceMod;

class Company implements Runnable {
    private Account account;
    private double amount;

    public Company(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        System.out.println("Adding " + amount + " to account " + account.getBalance());
        account.addAmount(amount);
        System.out.println("New balance after adding: " + account.getBalance());
    }
}
