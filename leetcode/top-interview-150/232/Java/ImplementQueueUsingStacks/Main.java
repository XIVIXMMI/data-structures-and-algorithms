/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println("peek(): " + queue.peek()); // 1
        System.out.println("pop(): " + queue.pop()); // 1
        System.out.println("pop(): " + queue.pop()); // 2

        queue.push(4);

        System.out.println("pop(): " + queue.pop()); // 3
        System.out.println("empty(): " + queue.empty()); // false
        System.out.println("pop(): " + queue.pop()); // 4
        System.out.println("empty(): " + queue.empty()); // true
    }
}