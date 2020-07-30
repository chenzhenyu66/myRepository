package dataStructure04_栈和队列.优先级队列;

import java.util.Arrays;

/**
 * 2020/3/6 21:22
 *
 * @author a1344
 * 说明：优先级队列，相当于插入队列之前先排序
 *  插入数据,时间复杂度O(n)
 */
public class PriorityQ {
    private int max;
    private long[] queArray;
    private int nItems;

    public PriorityQ(int s) {
        max = s;
        queArray = new long[max];
        nItems = 0;
    }

    public void insert(long item) {
        int j;

        if (nItems == 0)
            queArray[nItems++] = item;
        else {
            for (j = nItems - 1; j >= 0; j--) {
                if (item >queArray[j]) {
                    queArray[j+1] =queArray[j];
                }
                else
                    break;
            }
            queArray[j+1] = item;
            nItems++;
        }
    }
    //删去优先级最低的
    public long remove(){
        return queArray[--nItems];
    }
    public long peekMin(){
        return queArray[nItems-1];
    }

    public boolean isEmpty(){
        return (nItems == 0);
    }
    public boolean isFull(){
        return (nItems == max);
    }

    @Override
    public String toString() {
        return "PriorityQ{" +
                "max=" + max +
                ", queArray=" + Arrays.toString(queArray) +
                ", nItems=" + nItems +
                '}';
    }

}
