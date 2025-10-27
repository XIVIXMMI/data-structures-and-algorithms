package BenchmarkTest;

import java.util.concurrent.Semaphore;

public class BankAccountUsingSemaphore {

    private double balance;
    private Semaphore semaphore = new Semaphore(1);

    public BankAccountUsingSemaphore(double initialBalance) {
        this.balance = initialBalance;
    }

    public Semaphore getSemaphore() {
        return this.semaphore;
    }

    public void deposit(double amount) {
        try {
            semaphore.acquire();
            balance += amount;
        } catch (InterruptedException e) {
            Thread.currentThread().getName();
        } finally {
            semaphore.release();
        }
    }

    public void withdraw(double amount) {
        try {
            semaphore.acquire();
            if (balance - amount > 0)
                balance -= amount;
        } catch (InterruptedException e) {
            Thread.currentThread().getName();
        } finally {
            semaphore.release();
        }
    }

    public double getBalance() {
        try {
            semaphore.acquire();
            return balance;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return -1;
        } finally {
            semaphore.release();
        }
    }
}
