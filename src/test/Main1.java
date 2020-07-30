package test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2020/7/7 14:11
 *
 * @author a1344
 * 说明：
 */
public class Main1 {
    public static void main(String[] args) {
//        int m =3;
//        int n =4;
//        m = m ^ n;
//        n = m ^ n;
//        m = m ^ n;
//        System.out.println("m="+m);
//        System.out.println("n="+n);

//        int n = 60 & 15;
//        System.out.println(n);
//        System.out.println(Integer.toHexString(n));
//        System.out.printf("%x",n);

        int a = 1, b = 2, c = 3;

//        if (a > b)
//            if (a > c)
//                System.out.println(a);
//            else
//                System.out.println(c);
//        else
//            if (b > c)
//                System.out.println(b);
//            else
//                System.out.println(c);
//        int max = Math.max(Math.max(a, b), c);
//        System.out.println(max);

//        Scanner scanner = new Scanner(System.in);
//        int year = scanner.nextInt();
//        if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0)
//            System.out.println(year+"是闰年");
//        else
//            System.out.println(year+"不是闰年");
//        int i = 9;
//
//        switch(i){
//            default: System.out.println("default");
//            case 0: System.out.println("zero");
//            case 1: System.out.println("one");
//                break;
//            case 2: System.out.println("two");
//            case 3: System.out.println("three");
//        }
//        Scanner scanner = new Scanner(System.in);
//        double height = scanner.nextDouble();
//        double weight = scanner.nextDouble();
//        double BMI = weight / (height * height);
//        System.out.println("BMI值为："+BMI);
//        if (BMI <18.5)
//            System.out.println("过轻");
//        else if (BMI <24.5)
//            System.out.println("正常");
//        else if (BMI <28)
//            System.out.println("过重");
//        else if (BMI <32)
//            System.out.println("肥胖");
//        else
//            System.out.println("超胖");
//
//        scanner.cstartse();

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入型号和油量：");
//        int type = scanner.nextInt();
//        int liter = scanner.nextInt();
//        double price = 0;
//        if (type == 92){
//            if (liter>10){
//                price = liter * 6 * 0.9;
//            }else{
//                price = liter * 6;
//            }
//        }else if (type==95){
//            if (liter>20){
//                price = liter * 7 * 0.85;
//            }else{
//                price = liter * 7;
//            }
//        }
//        System.out.println(price);
//        scanner.cstartse();
//        for (int i = 100; i <= 999; i++) {
//            if (fun1(i)) System.out.println(i);
//        }
//        System.out.println(fun1(153));

//        for (int i = 1; i < 10; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print(j+"*"+i+"="+i*j);
//                System.out.print("\t");
//            }
//            System.out.println();
//        }
        int n = 5;
//        for (int i = 1; i <= n; i++) {
//            int j, k = 0;
//            j = i * 2 - 1;
//            k = (n * 2 - 1 - j) / 2;
//            for (int l = 0; l < k; l++) {
//                System.out.print(" ");
//            }
//            for (int l = 0; l < j; l++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
        for (int i = n; i >= 1; i--) {
            int j, k = 0;
            j = i * 2 - 1;
            k = (n * 2 - 1 - j) / 2;
            for (int l = 0; l < k; l++) {
                System.out.print(" ");
            }
            for (int l = 0; l < j; l++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static boolean fun1(int i) {
        int temp = 0;
        int target = i;
        while (i > 0) {
            temp += (int) Math.pow(i % 10, 3);
            i = i / 10;
        }
        if (temp == target)
            return true;
        return false;
    }

    public double getYearAwards(double price, int year) {
        double yearAwards = 0;
        if (year <= 2) {
            if (yearAwards >= 8000) {
                yearAwards = price * 1.2;
            } else {
                yearAwards = price;
            }
        } else if (year <= 5) {
            if (yearAwards >= 10000) {
                yearAwards = price * 2 + 5000;
            } else {
                yearAwards = price * 2;
            }
        } else {
            yearAwards = price * 3;
        }
        return yearAwards;
    }

    public String fun2(int i) {
        StringBuilder builder = new StringBuilder();
        while (i >= 2) {
            int x = 2;
            while (true) {
                if (i % x == 0) {
                    builder.append(x + "*");
                    break;
                }
                x++;
            }
            i = i / x;
        }
        String s = builder.toString();
        return s.substring(0, s.length() - 1);
    }

    @Test
    public void fun2Test() {
        System.out.println(fun2(99));
    }


    public int[] getLeastNumbers(int[] arr, int k) {
        int mid = arr.length / 2;
        if (k <= mid)
            for (int i = 0; i < k; i++) {
                int temp = Integer.MAX_VALUE;
                int index = 0;
                for (int j = i; j < arr.length; j++) {
                    if (temp > arr[j]) {
                        temp = arr[j];
                        index = j;
                    }
                }
                arr[index] = arr[i];
                arr[i] = temp;
            }
        else
            for (int i = arr.length - 1; i >= mid; i--) {
                int temp = Integer.MIN_VALUE;
                int index = 0;
                for (int j = 0; j <= i; j++) {
                    if (temp < arr[j]) {
                        temp = arr[j];
                        index = j;
                    }
                }
                arr[index] = arr[i];
                arr[i] = temp;
            }
        return Arrays.copyOf(arr, k);
    }

    @Test
    public void getLeastNumbersTest() {
        int[] a = {6, 5, 4, 3, 2, 1};
        int[] leastNumbers = getLeastNumbers(a, 4);
        for (int b : leastNumbers) {
            System.out.println(b);
        }
    }

    public void quickSort(int[] arr, int start, int end) {
        int i = start;
        int j = end;
        if (end > start) {
            int temp = arr[0];
            while (end != start) {
                while (end > start && arr[end] > temp)
                    end--;
                arr[start] = arr[end];
                while (end < start && arr[start] < temp)
                    start++;
                quickSort(arr, start, i - 1);
                quickSort(arr, i + 1, end);

            }
        }
    }

    public void quickSort2(int[] arr, int start, int end) {
        int i = start, j = end;
        int temp;
        if (i < j) {
            temp = arr[i];
            while (i != j) {
                while (j > i && arr[j] > temp) --j;
                arr[i] = arr[j];
                while (i < j && arr[i] < temp) ++i;
                arr[j] = arr[i];
            }
            arr[i] = temp;
            quickSort2(arr, start, i - 1);
            quickSort2(arr, i + 1, end);
        }
    }

    @Test
    public void quickSort2Test() {
        int[] arr = {1,2,3,4,5};
        quickSort2(arr, 0, arr.length - 1);
        for (int a : arr)
            System.out.println(a);
    }

}
