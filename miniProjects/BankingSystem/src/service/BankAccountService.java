package service;
import model.BankAccount;

public class BankAccountService {

    private static BankAccount account;

    public void deposit(double amount) {
        double currentBalance = account.getBalance() + amount;
        account.setBalance(currentBalance);
    }

    public double withDraw(double amount) {
        return account.getBalance() - amount;
    }

}
