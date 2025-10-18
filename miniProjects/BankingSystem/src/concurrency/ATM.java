package concurrency;

import exception.InsufficientFundsException;
import model.BankAccount;
import service.BankAccountService;

public class ATM extends Thread {

    private BankAccount account;
    private BankAccountService service;

    public ATM(BankAccount account, BankAccountService service) {
        this.account = account;
        this.service = service;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        // ATM-1, ATM-2, ATM-3 will deposit
        // ATM-4 ATM-5 will withdraw
        synchronized (service) {
            if (threadName.equals("ATM-4") || threadName.equals("ATM-5") || threadName.equals("ATM-6")) {
                // Deposit 10 time
                for (int i = 0; i < 20; i++) {
                    service.deposit(account, 1000);
                    System.out.println("[DEPOSIT] " + threadName + " Deposit 1000. Balance: " + account.getBalance());

                }
            } else {
                // Withdraw 10 time
                for (int i = 0; i < 11; i++) {
                    try {
                        service.withDraw(account, 2000);
                        System.out.println(
                                "[WITHDRAW] " + threadName + " Withdraw 2000. Balance: " + account.getBalance());
                    } catch (InsufficientFundsException e) {
                        System.out.println(" [WITHDRAW] " + threadName + " Insufficient balance ... current balance " + account.getBalance());
                    }
                }
            }
        }
    }

}
