package concurrency;

import model.BankAccount;
import service.BankAccountService;

public class Transaction extends Thread {

    private BankAccount from;
    private BankAccount to;
    private BankAccountService service;

    public Transaction(BankAccount from, BankAccount to, BankAccountService service) {
        this.from = from;
        this.to = to;
        this.service = service;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        for (int i = 0; i < 10; i++) {
            try {
                service.transfer(from, to, 100);
                System.out.println(threadName + " Transfered 100");
            } catch (Exception e) {
                System.out.println(threadName + " Transfered failed: " + e.getMessage());
            }
        }
    }

}
