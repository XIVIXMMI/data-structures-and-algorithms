import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    Deque<Integer> deque = new ArrayDeque<>();
    Deque<Integer> minStack = new ArrayDeque<>();

    // initialize the stack object
    public MinStack() {
        
    }

    // pushes the element value onto the stack
    public void push(int value) {
        if (minStack.isEmpty() || value <= minStack.peek())
            minStack.push(value);
        deque.push(value);
    }

    // removes the element value on top of the stack
    public void pop() {
        if (deque.peek().equals(minStack.peek()))
            minStack.pop();
        deque.pop();
    }

    // gets the top element of the stack
    public int top() {
        return deque.peek();
    }

    // retrieves the minimum element in the stack
    public int getMin() {
        return minStack.peek();
    }
}
