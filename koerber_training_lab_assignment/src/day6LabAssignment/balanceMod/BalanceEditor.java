package day6LabAssignment.balanceMod;

public class BalanceEditor extends Account {

    public static void main(String[] args) throws InterruptedException{

        Account acc = new Account("A0001","Vid",1000.00);
        Thread[] bankThreads = new Thread[100];
        Thread[] companyThreads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            bankThreads[i] = new Thread(new Bank(acc, 1000.0));
            bankThreads[i].start();
            companyThreads[i] = new Thread(new Company(acc, 5000.0));
            companyThreads[i].start();
            bankThreads[i].join();
            companyThreads[i].join();
        }
        System.out.println("Final account balance: " + acc.getBalance());
    }
}
