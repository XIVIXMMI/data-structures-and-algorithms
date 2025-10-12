import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Future;

import model.Order;
import model.Order.OrderStatus;
import service.Level1OrderProcessor;

public class Main {

    private static int threadPoolSize;
    private static int totalOrders;

    static Scanner sc = new Scanner(System.in);
    
    public static int inputThreadPoolSize() {
        System.out.println("Please enter thread pool size: " );
        threadPoolSize = sc.nextInt();
        System.out.println("Your thread pool size: " + threadPoolSize);

        return threadPoolSize;
    }
    
    public static int inputTotalOrders() {
        System.out.println("Please enter your total orders: " );
        totalOrders = sc.nextInt();
        System.out.println("Your total orders are: " + totalOrders);

        return totalOrders;
    }

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Level1OrderProcessor processor = new Level1OrderProcessor(inputThreadPoolSize());

        List<Order> orders = new ArrayList<>();
        int length = inputTotalOrders();
        for( int i = 0; i < length; i++){
            Order order = new Order(
                "ORDER" + String.format("%03d", i),
                "CUSTOMER" + String.format("%04d", i), 
                Math.random() * 1000);
            orders.add(order);
        }

        // Submit all orders
        List<Future<Order>> futures = new ArrayList<>();
        for(Order order : orders){
            Future<Order> future = processor.processOrder(order);
            futures.add(future);
        }

        // collect the result
        int completed = 0;
        int failed = 0;

        for(Future<Order> future : futures){
            try {
                Order result = future.get();
                if( result.getStatus() == OrderStatus.COMPLETED) 
                    completed++;
            } catch (Exception e){
                failed++;
                System.err.println("Order processing failed: " +e.getMessage());
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
        sc.close();
    }

}
