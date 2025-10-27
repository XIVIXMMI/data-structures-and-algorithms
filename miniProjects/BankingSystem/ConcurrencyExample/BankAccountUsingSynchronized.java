package ConcurrencyExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/*
 * This class is for learning purposes only.
 * The current logic contains several issues and is not production-safe.
 * It is just an example to demonstrate the use of synchronized, wait(), notify(), and notifyAll().
 *
 * ⚠️ Note: The current implementation may cause deadlock in the deposit/withdraw and transfer methods.
 * It is recommended to replace synchronized with ReentrantLock for better control and to avoid deadlocks.
 */
public class BankAccountUsingSynchronized {

    private String name;
    private double balance;
    private double minimumBalance = 100;

    public BankAccountUsingSynchronized(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " Blance increase by " + amount);
    }

    public synchronized void withDraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be positive");
        }
        try {
            while (balance - amount <= minimumBalance) {
                System.out.println(Thread.currentThread().getName() + " waiting to withdraw " + amount +
                        " current =" + balance);
                wait();
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount +
                    " new balance =" + balance);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }

    public void transfer(BankAccountUsingSynchronized from, BankAccountUsingSynchronized to, double amount) {
        if (from == to) {
            throw new IllegalArgumentException("Cannot transfer to the same account");
        }
        BankAccountUsingSynchronized firstLock = System.identityHashCode(from) < System.identityHashCode(to) ? from
                : to;

        BankAccountUsingSynchronized secondLock = System.identityHashCode(from) > System.identityHashCode(to) ? from
                : to;

        synchronized (firstLock) {
            synchronized (secondLock) {
                if (from.balance - amount >= minimumBalance) {
                    // from.withDraw(amount); // -> this is cause deadlock
                    // to.deposit(amount); // there is also
                    from.balance -= amount;
                    to.balance += amount;
                    System.out.println(Thread.currentThread().getName() + " transfered " + amount +
                            " from " + from.name + " to " + to.name);
                } else {
                    System.err.println(
                            Thread.currentThread().getName() + " failed to transfer due to insufficient balance!");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();

        BankAccountUsingSynchronized account_1 = new BankAccountUsingSynchronized("John", 3000);
        BankAccountUsingSynchronized account_2 = new BankAccountUsingSynchronized("Mabel", 4000);
        BankAccountUsingSynchronized account_3 = new BankAccountUsingSynchronized("Grayson", 3000);

        // Thread[] transactionals = new Thread[5];
        // transactionals[0] = new Thread(() -> {
        // account_1.transfer(account_1, account_2, 300);
        // });
        // transactionals[1] = new Thread(() -> {
        // account_2.transfer(account_2, account_1, 400);
        // });
        // transactionals[2] = new Thread(() -> {
        // account_3.transfer(account_3, account_1, 300);
        // });
        // transactionals[3] = new Thread(() -> {
        // account_1.transfer(account_1, account_3, 200);
        // });
        // transactionals[4] = new Thread(() -> {
        // account_2.transfer(account_2, account_3, 500);
        // });

        // for(int i = 0; i < transactionals.length; i++){
        // transactionals[i].setName("Transaction-" + (i+1));
        // transactionals[i].start();
        // }

        // for(Thread transaction : transactionals){
        // transaction.join();
        // }

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
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

        double totalBalance = account_1.balance + account_2.balance + account_3.balance;
        System.out.println("Balance account 1: " + account_1.balance);
        System.out.println("Balance account 2: " + account_2.balance);
        System.out.println("Balance account 3: " + account_3.balance);
        System.out.println("TOTAL BALANCE: " + totalBalance);
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("TIME RUNNING: " + endTime + " ms");
    }
}
