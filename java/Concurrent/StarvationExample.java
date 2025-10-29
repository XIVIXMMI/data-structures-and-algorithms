import java.util.concurrent.Semaphore;

public class StarvationExample {
    // Unfair semaphore — thread nào giành được thì chạy, không theo thứ tự
    private static final Semaphore semaphore = new Semaphore(1, false);

    public static void main(String[] args) {
        // Tạo 1 thread "ưu tiên cao" (chạy nhanh, release liên tục)
        Thread greedyThread = new Thread(() -> {
            while (true) {
                try {
                    semaphore.acquire();
                    System.out.println("[Greedy] Acquired the lock");
                    // Giả lập làm việc rất nhanh
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    semaphore.release();
                }
            }
        });

        // Tạo nhiều thread "thấp" hơn (chậm, nhưng cần được cơ hội)
        for (int i = 1; i <= 3; i++) {
            int id = i;
            new Thread(() -> {
                while (true) {
                    try {
                        semaphore.acquire();
                        System.out.println("    [Worker " + id + "] finally got the lock!");
                        Thread.sleep(100); // Giả lập làm việc lâu hơn
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        semaphore.release();
                    }
                }
            }).start();
        }

        greedyThread.start();
    }
}