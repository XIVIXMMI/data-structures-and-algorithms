package concurrency;

import model.BankAccount;

public class ATM extends Thread {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    @Override
    public synchronized void run() {
        String threadName = Thread.currentThread().getName();

        // ATM-1, ATM-2, ATM-3 will deposit
        // ATM-4 ATM-5 will withdraw
        if (threadName.equals("ATM-1") || threadName.equals("ATM-2") || threadName.equals("ATM-3")) {
            // Deposit 10 time
            for (int i = 0; i < 10; i++) {
                synchronized (account) {
                    double currentBalance = account.getBalance();
                    double newBalance = currentBalance + 100;
                    account.setBalance(newBalance);
                    System.out.println(threadName + " deposit 100. Balance: " + account.getBalance());
                }
            }
        } else {
            // Withdraw 10 time
            for (int i = 0; i < 10; i++) {
                synchronized (account) {
                    double currentBalance = account.getBalance();
                    double newBalance = currentBalance - 50;
                    account.setBalance(newBalance);
                    System.out.println(threadName + " withdraw 50. Balance: " + account.getBalance());
                }
            }
        }
    }

}
