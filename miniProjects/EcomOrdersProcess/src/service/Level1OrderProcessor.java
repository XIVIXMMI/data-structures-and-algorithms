package service;

import model.Order;
import model.Order.OrderStatus;

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
                String threadName = Thread.currentThread().getName();
                System.out.println("[" + threadName + "] Started processing: " + order.getOrderId());

                Thread.sleep(randomDelay); // simulate processing time
                order.setStatus(OrderStatus.COMPLETED);

                System.out.println("[" + threadName + "] Completed processing: " + order.getOrderId());
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

}
