import concurrency.ATM;
import model.BankAccount;

public class Main {

    public static void main(String[] args) throws InterruptedException  {
        
        BankAccount account = new BankAccount(1000);

        ATM[] atms = new ATM[5];
        for(int i = 1; i <= atms.length; i++) {
            atms[i-1] = new ATM(account);
            atms[i-1].setName("ATM-" + i);
            atms[i-1].start();
        }

        for(ATM atm : atms){
            atm.join(); // Waits for this thread to finish
        }

        System.out.println("FINAL BALANCE: " + account.getBalance());

    }
}