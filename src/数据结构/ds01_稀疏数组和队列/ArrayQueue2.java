package 从零开始的数据结构.ds01_稀疏数组和队列;

/**
 * 2020/4/9 11:44
 *
 * @author a1344
 * 说明：环形的队列
 *
 * 因为环形队列在 rear == front的时候 ，不知道是空还是满，所以会少用一个空间
 */
public class ArrayQueue2 {
    private int maxSize;
    private int front = 0;
    private int rear = 0;
    private int[] arr;

    /**
     * 初始化
     * @param size 初始化队列的大小
     */
    public ArrayQueue2(int size){
        maxSize = size + 1;         //size+1的原因是环形队列会少用一个空间，但还要满足客户需求
        arr = new int[maxSize];
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return front == rear ;
    }

    /**
     * 判断是否为满
     * @return
     */
    public boolean isFull(){
        return ((rear + 1) % maxSize) == front;
    }

     /**
     * 添加数据到队列中
     * @param n 要添加的数据
     */
    public void addQueue(int n){
        if (isFull()){
            System.out.println("已经满了");
            return;
        }
        arr[rear] = n;

        rear = (rear + 1) % maxSize;
    }

    public Integer remove(){
        if (isEmpty()){
            System.out.println("已经空了");
            return null;
        }

        int temp = front;
        front = (front+1) % maxSize;
        return arr[temp];
    }

    public void showAll(){
        if (isEmpty()){
            System.out.println("数组是空的");
            return;
        }
        for (int i:arr) {
            System.out.print(i+"\t");
        }
    }
    public int getSize(){
        return (rear + maxSize -front) % maxSize;
    }
    static class Test{
        public static void main(String[] args) {
            ArrayQueue2 queue2 = new ArrayQueue2(3);
            queue2.addQueue(1);
            queue2.addQueue(2);
            queue2.addQueue(3);
            System.out.println(queue2.remove());
            System.out.println(queue2.remove());
            System.out.println(queue2.remove());
            queue2.addQueue(4);
            queue2.addQueue(5);
            queue2.addQueue(6);
            System.out.println(queue2.remove());
            System.out.println(queue2.remove());
//            System.out.println(queue2.isEmpty());
//            System.out.println(queue2.isFull());

            System.out.println(queue2.getSize());

        }
    }
}
