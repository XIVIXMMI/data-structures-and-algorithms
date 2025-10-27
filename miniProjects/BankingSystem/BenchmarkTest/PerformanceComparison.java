package BenchmarkTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class PerformanceComparison {
    
    private static final int THREADS = 100;
    private static final int OPERATIONS_PER_THREADS = 1000;
    private static final double INITIAL_BALANCE = 1000;

    public static void main(String[] args) throws InterruptedException{
        benmark("Synchronized", () -> new BankAccountUsingSynchronized(INITIAL_BALANCE));
        benmark("ReentrantLock", () -> new BankAccountUsingReentrantLock(INITIAL_BALANCE));
        benmark("Semaphore", () -> new BankAccountUsingSemaphore(INITIAL_BALANCE));
    }

    public static void benmark(String name, Supplier<Object> supplier) throws InterruptedException {
        // STEP 1: create object for bankaccount by using supplier.get()
        Object account = supplier.get();
        // STEP 2: Create a thread pool by using executorService
        ExecutorService executor = Executors.newFixedThreadPool(THREADS);
        long start = System.currentTimeMillis();
        // STEP 3: loops througth all threads and submit() and loops throught each thread, call each-instance of the bankaccount
        for( int i = 0; i < THREADS; i++){
            executor.submit(() -> {
                for(int j = 0; j < OPERATIONS_PER_THREADS; j++){
                    if( account instanceof BankAccountUsingSynchronized acc){
                        acc.deposit(10);
                        acc.withdraw(5);
                    }
                    else if( account instanceof BankAccountUsingReentrantLock acc){
                        acc.deposit(10);
                        acc.withdraw(5);
                    }
                    else if( account instanceof BankAccountUsingSemaphore acc){
                        acc.deposit(10);
                        acc.withdraw(5);
                    }
                }
            });
        }

        // STEP 4: shutdown and wait all thread to complete
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS );

        long end = System.currentTimeMillis();

        // STEP 5: Create finalBalance to print all case 'Synchronized', 'ReentrantLock', 'Semaphore'
        double finalBalance = switch(name) {
            case "Synchronized" -> ((BankAccountUsingSynchronized) account).getBalance();
            case "ReentrantLock" -> ((BankAccountUsingReentrantLock) account).getBalance();
            case "Semaphore" -> ((BankAccountUsingSemaphore) account).getBalance();
            default -> 0;
        };
        
        System.out.printf("%-15s | Time: %5d ms | Final Balance: %.2f%n",
                name, (end - start), finalBalance);
    }
}
