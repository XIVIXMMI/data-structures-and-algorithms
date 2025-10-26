package ConcurrencyExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccountUsingReentrantLock {
    private String name;
    private double balance;
    private double minimumBalance = 100;

    private Lock lock = new ReentrantLock();

    public Lock getLock() {
        return this.lock;
    }

    public BankAccountUsingReentrantLock(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
        System.out.println("Blance increase by" + amount);
    }

    public synchronized void withDraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be positive");
        }
        if (balance - amount >= minimumBalance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance, need " + amount + " current balance " + balance);
        }
    }

    public void transfer(BankAccountUsingReentrantLock from, BankAccountUsingReentrantLock to, double amount) {
        if (from == to) {
            throw new IllegalArgumentException("Cannot transfer to the same account");
        }
        BankAccountUsingReentrantLock firstLock = System.identityHashCode(from) < System.identityHashCode(to) ? from
                : to;

        BankAccountUsingReentrantLock secondLock = System.identityHashCode(from) > System.identityHashCode(to) ? from
                : to;

        try {
            firstLock.getLock().lock();
            ;
            try {
                secondLock.getLock().lock();
                ;
                if (from.balance - amount >= minimumBalance) {
                    from.withDraw(amount);
                    to.deposit(amount);
                    System.out.println(Thread.currentThread().getName() + " transfered " + amount +
                            " from " + from.name + " to " + to.name);
                } else {
                    System.err.println(
                            Thread.currentThread().getName() + " failed to transfer due to insufficient balance!");
                }
            } finally {
                secondLock.getLock().unlock();
            }
        } finally {
            firstLock.getLock().unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();

        BankAccountUsingReentrantLock account_1 = new BankAccountUsingReentrantLock("John", 3000);
        BankAccountUsingReentrantLock account_2 = new BankAccountUsingReentrantLock("Mabel", 4000);
        BankAccountUsingReentrantLock account_3 = new BankAccountUsingReentrantLock("Grayson", 3000);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 1000; i++) {
            executor.submit(() -> account_1.transfer(account_1, account_2, 200));
            executor.submit(() -> account_2.transfer(account_2, account_3, 500));
            executor.submit(() -> account_3.transfer(account_3, account_1, 200));
            executor.submit(() -> account_2.transfer(account_2, account_1, 300));
            executor.submit(() -> account_1.transfer(account_1, account_3, 400));
        }

        executor.shutdown();
        executor.awaitTermination(20, TimeUnit.SECONDS);


        for (Thread t : Thread.getAllStackTraces().keySet()) {
            if (t.isAlive() && !t.isDaemon()) {
                System.out.println("ALIVE THREAD: " + t.getName() + " - " + t.getState());
            }
        }

        long endTime = System.currentTimeMillis() - startTime;
        double totalBalance = account_1.balance + account_2.balance + account_3.balance;
        System.out.println("Balance account 1: " + account_1.balance);
        System.out.println("Balance account 2: " + account_2.balance);
        System.out.println("Balance account 3: " + account_3.balance);
        System.out.println("TOTAL BALANCE: " + totalBalance);
        System.out.println("TIME RUNNING: " + endTime + " ms");

    }
}
