import concurrency.Transaction;
import model.BankAccount;
import service.BankAccountService;

public class Main {

    public static void main(String[] args) throws InterruptedException  {
        
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(1000);
        BankAccount account3 = new BankAccount(1000);

        BankAccountService service = new BankAccountService();

        Transaction[] transactions = new Transaction[5];
        transactions[0] = new Transaction(account1, account2, service);
        transactions[1] = new Transaction(account2, account3, service);
        transactions[2] = new Transaction(account3, account1, service);
        transactions[3] = new Transaction(account1, account3, service);
        transactions[4] = new Transaction(account2, account1, service);

        for(int i = 0; i < transactions.length; i++){
            transactions[i].setName("[Transaction-"+(i+1)+"]");
            transactions[i].start();
        }

        for(Transaction transaction : transactions){
            transaction.join();
        }

        double totalBalance = account1.getBalance() + account2.getBalance() + account3.getBalance();
        System.out.println("Balance account 1: " + account1.getBalance());
        System.out.println("Balance account 2: " + account2.getBalance());
        System.out.println("Balance account 3: " + account3.getBalance());
        System.out.println("TOTAL BALANCE: " + totalBalance);

    }
}