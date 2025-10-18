package service;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

import exception.InsufficientFundsException;
import model.BankAccount;

public class BankAccountService {

    private final Lock lock = new ReentrantLock();

    public synchronized void deposit(BankAccount account, double amount) {
        double currentBalance = account.getBalance() + amount;
        account.setBalance(currentBalance);
        notifyAll();
    }

    public synchronized void withDraw(BankAccount account, double amount) throws InsufficientFundsException {
        long startTime = System.currentTimeMillis();
        while (account.getBalance() - amount < account.getMinimumBalance() || amount > account.getBalance()) {
            try {
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (System.currentTimeMillis() - startTime > 10000) {
                throw new InsufficientFundsException(" Insufficient balance, waiting ...");
            }
        }

        double currentBalance = account.getBalance() - amount;
        account.setBalance(currentBalance);
    }

    public void transfer(BankAccount account, BankAccount target, double amount) throws InsufficientFundsException {
        // BankAccount firstLock = account.hashCode() < target.hashCode() ? account :
        // target;
        // BankAccount secondLock = account.hashCode() < target.hashCode() ? target :
        // account;

        // synchronized (firstLock) {
        // synchronized (secondLock) {
        // if (account.getBalance() < amount || account.getBalance() <
        // account.getMinimumBalance()) {
        // throw new InsufficientFundsException("Insufficient balance in source
        // account");
        // }

        // double currentBalance = account.getBalance();
        // double newBalance = currentBalance - amount;
        // account.setBalance(newBalance);

        // double targetBalance = target.getBalance();
        // double updateBalance = targetBalance + amount;
        // target.setBalance(updateBalance);
        // }
        // }

        BankAccount firstLock = System.identityHashCode(account) < System.identityHashCode(target) ? account : target;
        BankAccount secondLock = System.identityHashCode(account) < System.identityHashCode(target) ? target: account;
        
        firstLock.getLock().lock();
        try{
            secondLock.getLock().lock();
            try{
                if( account.getBalance() < amount || account.getBalance() < account.getMinimumBalance()){
                    throw new InsufficientFundsException(" Insuffient balance has " + account.getBalance() +", needs " + amount);
                }

                double currentBalance = account.getBalance();
                double newBalance = currentBalance - amount;
                account.setBalance(newBalance);

                double targetBalance = target.getBalance();
                double updateBalance = targetBalance + amount;
                target.setBalance(updateBalance);
                } finally {
                    secondLock.getLock().unlock();
                } 
            } finally {
                firstLock.getLock().unlock();
            }
        }

}
