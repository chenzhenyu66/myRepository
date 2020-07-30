package dataStructure03_简单排序.选择排序;


/**
 * 2020/3/6 9:05
 *
 * @author a1344
 * 说明：
 */
public class ArraySel {
    private long[] a;
    private int n;

    public ArraySel(int max){
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

    //选择排序，从小到大
    //找到其中最小的一个，然后比较   排序时间复杂度O(n^2) 交换时间复杂度O(n)
    public void selectionSort(){
      int out,in,min;
      for (out =0 ;out<n-1;out++){
          min =out;
          for(in =out+1;in<n;in++){
              if (a[in] <a[min])
                  min =in;
              swap(out,min);
          }
      }
    }

    public void swap(int one,int two){
        long temp =a[one];
        a[one] =a[two];
        a[two] = temp;
    }

}
