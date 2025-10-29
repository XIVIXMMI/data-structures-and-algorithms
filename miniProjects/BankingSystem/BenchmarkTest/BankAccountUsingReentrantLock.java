package BenchmarkTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccountUsingReentrantLock {

    private double balance;
    private Lock lock = new ReentrantLock();

    public BankAccountUsingReentrantLock(double initialBalance) {
        this.balance = initialBalance;
    }

    public Lock getLock() {
        return this.lock;
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) {
        lock.lock();
        try {
            if (balance - amount > 0)
                balance -= amount;
        } finally {
            lock.unlock();
        }
    }

    public double getBalance() {
        lock.lock();
        try {
            return this.balance;
        } finally {
            lock.unlock();
        }
    }
}
