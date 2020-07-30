package dataStructure03_简单排序.冒泡排序;


/**
 * 2020/3/6 9:05
 *
 * @author a1344
 * 说明：
 */
public class ArrayBub {
    private long[] a;
    private int n;

    public ArrayBub(int max){
        a = new long[max];
        n=0;
    }
    public void insert(long value){
        a[n] =value;
        n++;
    }

    public void display(){
        for (int j =0;j<n;j++)
            System.out.print(a[j]+" ");
        System.out.println();
    }

    //两两比较，从小到大，循环时间复杂度：O(n^2)，交换时间复杂度O(n^2)
    public void bubbleSort(){
        int out ,in;
        for (out=n-1;out>1;out--){
            for (in = 0;in<out;in++){
                if (a[in]>a[in+1])
                    swap(in,in+1);
            }
        }
    }

    public void swap(int one,int two){
        long temp =a[one];
        a[one] =a[two];
        a[two] = temp;
    }

}
