package dataStructure04_栈和队列.简单的栈;


import java.util.Arrays;

/**
 * 2020/3/6 10:33
 *
 * @author a1344
 * 说明：
 */
public class StackX {
    private int max;
    private long[] stackArray;
    private int top;

    public StackX(int s) {
        max = s;
        stackArray = new long[max];
        top = -1;
    }

    public void push(long num) {
        stackArray[++top] = num;
    }

    public long pop() {
        return stackArray[top--];
    }

    public long peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == max -1);
    }

    @Override
    public String toString() {
        return "StackX{" +
                "max=" + max +
                ", stackArray=" + Arrays.toString(stackArray) +
                ", top=" + top +
                '}';
    }
}
