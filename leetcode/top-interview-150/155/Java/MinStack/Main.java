/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(5);
        minStack.push(3);
        minStack.push(3);
        System.out.println(minStack.getMin()); // expect 3

        minStack.pop();
        System.out.println(minStack.getMin()); // expect 3 (still one 3 left)
        System.out.println(minStack.top()); // expect 3

        minStack.pop();
        System.out.println(minStack.getMin()); // expect 5
        System.out.println(minStack.top()); // expect 5

        minStack.push(2);
        System.out.println(minStack.getMin()); // expect 2
        System.out.println(minStack.top()); // expect 2
    }
}
