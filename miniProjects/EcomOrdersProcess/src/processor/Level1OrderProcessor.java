package processor;

import model.Order;
import model.Order.OrderStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Level1OrderProcessor {

    private final ExecutorService executorService;

    public Level1OrderProcessor(int threadPoolSize) {
        // Initial executorService with fixed thread pool
        executorService = Executors.newFixedThreadPool(threadPoolSize);
    }

    public Future<Order> processOrder(Order order) {
        // submit task to proccess order and future
        int randomDelay = 1000 + (int) (Math.random() * 2000);
        Future<Order> future =  executorService.submit(new Callable<Order>() {

            @Override
            public Order call() throws Exception {
                Thread.sleep(randomDelay); // simulate processing time
                order.setStatus(OrderStatus.COMPLETED);
                return order;
            }

        });
        return future; // return future object
    }

    public void shutdown() {
        // Shutdown executor properly
        try {
            executorService.shutdown(); // Stop recieve new task
            // wait for 60s to task complete
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                // if timeout → force shutdown
                executorService.shutdownNow();
            }

        } catch (InterruptedException e) {
            // If interrupt when waiting
            executorService.shutdownNow();
            // preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws Exception {
        Level1OrderProcessor processor = new Level1OrderProcessor(10);

        long startTime = System.currentTimeMillis();

        // create 100 orders
        List<Order> orders = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Order order = new Order(
                    "ORD" + String.format("%03d", i), // ORD001, ORD002...
                    "CUST" + i,
                    Math.random() * 1000 // random amount
            );
            orders.add(order);
        }

        // Submit all orders
        List<Future<Order>> futures = new ArrayList<>();

        // Submit all
        for (Order order : orders) {
            Future<Order> future = processor.processOrder(order);
            futures.add(future);
        }

        // collect the result
        int completed = 0;
        int failed = 0;

        for (Future<Order> future : futures) {
            try {
                Order result = future.get(); // ← get the result (blocking)
                if (result.getStatus() == OrderStatus.COMPLETED) {
                    completed++;
                }
            } catch (Exception e) {
                failed++;
                System.err.println("Order processing failed: " + e.getMessage());
            }
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println("=== Statistics ===");
        System.out.println("Total orders: " + orders.size());
        System.out.println("Completed: " + completed);
        System.out.println("Failed: " + failed);
        System.out.println("Total time: " + totalTime / 1000.0 + "s");
        System.out.println("Average time per order: " + (totalTime / orders.size()) / 1000.0 + "s");

        processor.shutdown();
    }
}
