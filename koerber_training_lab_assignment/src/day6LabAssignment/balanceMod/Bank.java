package day6LabAssignment.balanceMod;

class Bank implements Runnable {
    private Account account;
    private double amount;

    public Bank(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        System.out.println("Removing " + amount + " from account " + account.getBalance());
        account.subtractAmount(amount);
        System.out.println("New balance after removing: " + account.getBalance());
    }
}
