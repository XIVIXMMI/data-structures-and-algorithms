package model;

public class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public double setBalance(double balance) {
        return this.balance = balance;
    }
}
