package test;

import org.junit.Test;

import java.util.Stack;

/**
 * 2020/7/6 16:37
 *
 * @author a1344
 * 说明：
 */
public class MinStack {
    Stack<Integer> A,B;

    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.push(x);
        if (B.isEmpty() || B.peek() > x)
            B.push(x);
    }

    public void pop() {
        int temp = A.pop();
        if (temp == B.peek())
            B.pop();
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        if (B.isEmpty()) return 0;
        return B.peek();
    }

    @Test
    public void minStackTest(){
        MinStack stack = new MinStack();
        stack.push(3);
//        stack.push(2);
//        stack.push(1);

        System.out.println(stack.min());
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.min());
    }
}
