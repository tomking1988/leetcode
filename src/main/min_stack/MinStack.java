package min_stack;

import java.util.Stack;

public class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> origin;
    Stack<Integer> minStack;
    public MinStack() {
         origin = new Stack<Integer>();
         minStack = new Stack<Integer>();
    }

    public void push(int x) {
        origin.push(x);
        if(minStack.empty() || x <= minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop() {
        int x = origin.pop();
        if(x == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return origin.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
