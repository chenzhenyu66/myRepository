package dataStructure04_栈和队列.简单的队列;

/**
 * 2020/3/6 21:08
 *
 * @author a1344
 * 说明：简单的队列
 */
public class QueueX {
    private int max;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public QueueX(int s) {
        max = s;
        queArray = new long[max];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(long j) {
        if (rear == max - 1)
            rear = -1;

        queArray[++rear] = j;
        nItems++;
    }

    public long remove(){
        long temp = queArray[front++];
        if (front == max)
            front = 0;
        nItems--;
        return temp;
    }

    public long peekFront(){
        return queArray[front];
    }

    public boolean isEmpty(){
        return (nItems==0);
    }

    public boolean isFull(){
        return (nItems==max);
    }
    public int size(){
        return nItems;
    }


}
