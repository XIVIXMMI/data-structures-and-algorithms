public class Main {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println(queue.peek()); // should print 1
        System.out.println(queue.pop());  // should print 1
        System.out.println(queue.pop());  // should print 2

        queue.push(4);

        System.out.println(queue.pop());  // should print 3
        System.out.println(queue.empty()); // should print false
        System.out.println(queue.pop());  // should print 4
        System.out.println(queue.empty()); // should print true
    }
}
