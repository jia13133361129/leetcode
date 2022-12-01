import java.util.ArrayDeque;
import java.util.Deque;

class MyQueue {

    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public MyQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()){
            while (!inStack.isEmpty()){
                Integer i = inStack.pop();
                outStack.push(i);
            }
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()){
            while (!inStack.isEmpty()){
                Integer i = inStack.pop();
                outStack.push(i);
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}