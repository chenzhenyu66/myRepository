package dataStructure02_数组.有序数组二分查找;

public class OrdArray {
    private long[] a;
    private int n;

    public OrdArray(int max) {
        a = new long[max];
        n = 0;
    }

    public int size() {
        return n;
    }

    public int find(long searchKey) {
        int lower = 0;
        int upper = n - 1;
        int curIn;

        while (true) {
            curIn = (lower + upper) / 2;
            if (a[curIn] == searchKey)
                return curIn;
            else if (lower > upper)
                return n;                        //没找到
            else {
                if (a[curIn] < searchKey)
                    lower = curIn + 1;
                else
                    upper = curIn - 1;
            }
        }
    }

    //边存边插入数据(从小到大)
    public void insert(long value) {
        int j;
        for (j = 0; j < n; j++)
            if (a[j] > value)
                break;
        for (int k = n; k > j; k--)
            a[k] = a[k - 1];
        a[j] = value;
        n++;
    }

    public boolean delete(long value) {
        int j = find(value);
        if (j == n)
            return false;
        else {
            for (int k = j; k < n; k++) {
                a[k] = a[k + 1];
            }
            n--;
            return true;
        }
    }

    public void display() {
        for (int j = 0; j < n; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println();
    }
}
