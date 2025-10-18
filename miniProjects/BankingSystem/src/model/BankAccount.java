package model;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private double balance;

    private double minimumBalance = 100;

    private final Lock lock = new ReentrantLock();

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public Lock getLock(){
        return this.lock;
    }

    // Getter & Setter
    public double getBalance() {
        return this.balance;
    }

    public double setBalance(double balance) {
        return this.balance = balance;
    }

    public double getMinimumBalance(){
        return this.minimumBalance;
    }
}
