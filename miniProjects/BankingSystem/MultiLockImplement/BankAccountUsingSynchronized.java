package MultiLockImplement;

public class BankAccountUsingSynchronized {

    private String name;
    private double balance;
    private double minimumBalance = 100;

    public BankAccountUsingSynchronized(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("Blance increase " + amount);
    }

    public synchronized void withDraw(double amount) {
        if (balance > minimumBalance) {
            balance -= amount;
        } else {
            System.out.println("Insuffient balance, need " + amount + "current balance " + balance);
        }
    }

    public void transfer(BankAccountUsingSynchronized from, BankAccountUsingSynchronized to, double amount) {
        BankAccountUsingSynchronized firstLock = System.identityHashCode(from) < System.identityHashCode(to) ? from
                : to;

        BankAccountUsingSynchronized secondLock = System.identityHashCode(from) > System.identityHashCode(to) ? from
                : to;

        synchronized (firstLock) {
            synchronized (secondLock) {
                if (from.balance > amount) {
                    from.withDraw(amount);
                    to.deposit(amount);
                    System.out.println(Thread.currentThread().getName() + " transfered " + amount +
                            " from " + from.name + " to " + to.name);
                } else {
                    System.err.println(
                            Thread.currentThread().getName() + " failed to transfer due to insufficient balance!");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        BankAccountUsingSynchronized account_1 = new BankAccountUsingSynchronized("John", 3000);
        BankAccountUsingSynchronized account_2 = new BankAccountUsingSynchronized("Mabel", 4000);
        BankAccountUsingSynchronized account_3 = new BankAccountUsingSynchronized("Grayson", 3000);

        Thread[] transactionals = new Thread[5];
        transactionals[0] = new Thread(() -> {
            account_1.transfer(account_1, account_2, 300);
        });
        transactionals[1] = new Thread(() -> {
            account_2.transfer(account_2, account_1, 400);
        });
        transactionals[2] = new Thread(() -> {
            account_3.transfer(account_3, account_1, 300);
        });
        transactionals[3] = new Thread(() -> {
            account_1.transfer(account_1, account_3, 200);
        });
        transactionals[4] = new Thread(() -> {
            account_2.transfer(account_2, account_3, 500);
        });

        for(int i = 0; i < transactionals.length; i++){
            transactionals[i].setName("Transaction-" + (i+1));
            transactionals[i].start();
        }

        for(Thread transaction : transactionals){
            transaction.join();
        }
        
        double totalBalance = account_1.balance + account_2.balance + account_3.balance;
        System.out.println("Balance account 1: " + account_1.balance);
        System.out.println("Balance account 2: " + account_2.balance);
        System.out.println("Balance account 3: " + account_3.balance);
        System.out.println("TOTAL BALANCE: " + totalBalance);
    }
}
