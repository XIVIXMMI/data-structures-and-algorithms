import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {

    Deque<Integer> mainDeque = new ArrayDeque<>();
    Deque<Integer> auxiliaryDeque = new ArrayDeque<>();

    public MyQueue() {

    }

    public void push(int x) {
        while (!mainDeque.isEmpty()) {
            auxiliaryDeque.push(mainDeque.pop());
        }
        auxiliaryDeque.push(x);
        while(!auxiliaryDeque.isEmpty()) {
            mainDeque.push(auxiliaryDeque.pop());
        }

    }

    /*
        push (1) -> main == null -> aux.push(1) -> main = aux.push(aux.pop()) -> main[1]
        push (2) -> main != null -> aux.push(main.pop) -> aux[1]; main=[] -> aux.push(2); aux[1,2] -> main.push(aux.pop()) -> main[2,1]
    */


    public int pop() {
        return mainDeque.pop();
    }

    public int peek() {
        return mainDeque.peek();
    }

    public boolean empty() {
        return mainDeque.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
