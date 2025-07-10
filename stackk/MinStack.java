package stackk;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 155. 最小栈
 */
class MinStack {
    Deque<Integer>xstack;
    Deque<Integer>minStack;
    
    public MinStack() {
        xstack=new LinkedList<>();
        minStack=new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        xstack.push(val);
        minStack.push(Math.min(val,minStack.peek()));
    }
    
    public void pop() {
        xstack.pop();
        minStack.pop();
    }
    
    public int top() {
        return xstack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        // 测试入栈
        minStack.push(3);
        minStack.push(5);
        minStack.push(2);
        minStack.push(1);

        // 测试获取栈顶和最小值
        System.out.println("Top element: " + minStack.top()); // 应该输出 1
        System.out.println("Minimum element: " + minStack.getMin()); // 应该输出 1

        // 测试出栈
        minStack.pop(); // 弹出 1
        System.out.println("Top element after pop: " + minStack.top()); // 应该输出 2
        System.out.println("Minimum element after pop: " + minStack.getMin()); // 应该输出 2

        minStack.pop(); // 弹出 2
        System.out.println("Top element after another pop: " + minStack.top()); // 应该输出 5
        System.out.println("Minimum element after another pop: " + minStack.getMin()); // 应该输出 3
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */