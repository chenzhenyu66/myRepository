package dataStructure03_简单排序.插入排序;


/**
 * 2020/3/6 9:05
 *
 * @author a1344
 * 说明：这里是插入排序，对象排序利用compareTo()方法就行
 */
public class ArrayIns {
    private long[] a;
    private int n;

    public ArrayIns(int max) {
        a = new long[max];
        n = 0;
    }

    public void insert(long value) {
        a[n] = value;
        n++;
    }

    public void display() {
        for (int j = 0; j < n; j++)
            System.out.print(a[j] + " ");
        System.out.println();
    }

    //插入排序
    //思想:每步将一个待排序的记录，按其关键码值的大小插入前面已经排序的文件中适当位置上，直到全部插入完为止。
    //时间复杂度排序加交换总共O(n^2)

    public void insertionSort() {
        int in, out;
        for (out = 1; out < n; out++) {
            long temp = a[out];
            in = out;
            while (in > 0 && a[in - 1] >= temp) {
                a[in] = a[in - 1];
                --in;
            }
            a[in] = temp;
        }
    }


}
