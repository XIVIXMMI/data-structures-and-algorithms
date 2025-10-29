package BenchmarkTest;

public class BankAccountUsingSynchronized {
    
    private double balance;

    public BankAccountUsingSynchronized(double initialBalance){
        this.balance = initialBalance;
    }
    public synchronized void deposit(double amount){
        balance += amount;
    }
    public synchronized void withdraw(double amount){
        if( balance - amount > 0)
            balance -= amount;
    }

    public synchronized double getBalance(){
        return this.balance;
    }
}
