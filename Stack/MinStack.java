import java.util.Stack;

class MinStack {

    /** initialize your data structure here. */

    Stack<Integer[]> stack;
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.empty())
            stack.push(new Integer[] {x, x});
        else {
            int min = stack.peek()[1];
            stack.push(new Integer[]{x, Math.min(x, min)});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */