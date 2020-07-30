package 从零开始的数据结构.ds01_稀疏数组和队列;

/**
 * 2020/4/9 11:43
 *
 * @author a1344
 * 说明：普通的队列 先进先出
 * 缺点:不能复用
 */
public class ArrayQueue {
    private int front;      //头指针
    private int rear;       //尾指针
    private int maxSize;    //最大容量
    private int arr[];

    /**
     * 创建构造器
     */
    public ArrayQueue(int size){
        //做初始化数据
        maxSize = size;
        arr = new int[maxSize];
        front = -1;
        rear = -1;

    }

    /**
     * 判断是否为空
     */
    public boolean isEmpty(){
        return rear == front;
    }

    /**
     * 判断是否满了
     */
    public boolean isFull(){
        return rear == (maxSize - 1);
    }

    /**
     * 添加数据到队列中
     */
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列已经满了");
            return;
        }
        rear++;
        arr[rear] = n;
    }


    /**
     * 删除数据(出队列)
     */
    public Integer remove(){
        if (isEmpty()){
            System.out.println("数组已经空了");
            return null;
        }
        front++;
        return arr[front];
    }

    /**
     * 显示所有的数据
     */
    public void showAll(){
        if (isEmpty()){
            System.out.println("数组是空的");
            return;
        }
        for (int i:arr) {
            System.out.print(i+"\t");
        }
    }
    private static class Test{
        public static void main(String[] args) {
            ArrayQueue queue = new ArrayQueue(5);
            queue.addQueue(8);
            queue.addQueue(10);
            queue.addQueue(10);
            queue.addQueue(11);
            queue.addQueue(12);

            System.out.println(queue.isFull());
            queue.remove();
            queue.addQueue(13);
        }
    }
}
