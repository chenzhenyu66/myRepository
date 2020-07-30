package 从零开始的数据结构.ds01_稀疏数组和队列;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 2020/4/9 11:12
 *
 * @author a1344
 * 说明：将数组保存到文件中，并读取文件的过程
 */
public class SparseArray2 {
    public static void main(String[] args) {
        //初始化一个二维数组
        // 0代表无子 1代表白色，2代表黑色
        int arr[][] = new int[11][11];
        arr[5][1] =1;
        arr[3][8] =2;
        arr[8][4] =2;

        System.out.println("原始数组表：");
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length; j++) {
//
//            }
//        }
        for (int[] row:arr) {
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //遍历得到稀疏数组
        int sum = 0;
        for (int[] row:arr) {
            for(int data:row){
                if (data != 0){
                    sum++;
                }
            }
        }
        //创建一个稀疏数组
        int sparse[][] = new int[sum+1][3];
        //初始化第一行
        sparse[0][0] = arr.length;
        sparse[0][1] = arr[0].length;
        sparse[0][2] = sum;

        //遍历数组得到稀疏数组
        int sparseRow = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0){
                    sparse[sparseRow][0] = i;
                    sparse[sparseRow][1] = j;
                    sparse[sparseRow][2] = arr[i][j];

                    sparseRow++;
                }
            }
        }

//        //遍历得到的稀疏数组
//        for (int[] row:sparse) {
//            for(int data:row){
//                System.out.printf("%d\t",data);
//            }
//            System.out.println();
//        }

        //将稀疏数组存入文件中
        try {
            FileWriter writer = new FileWriter("D:\\1.txt");
            for (int[] row:sparse) {
                for(int data:row){
                    writer.write(data+"\t");
                }
                writer.write("\n");
            }
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        //将稀疏数组从文件读取出来
        int sparse2[][] = new int[sum+1][3];

        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\1.txt"));
            String line;
            int row = 0;

            while ((line = reader.readLine()) != null){
                String[] temp = line.split("\t");
                for (int i = 0; i < temp.length ; i++) {
                    sparse2[row][i] = Integer.parseInt(temp[i]);
                }
                row++;
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        for (int i = 0; i < sparse2.length; i++) {
            for (int j = 0; j < sparse2[0].length; j++) {
                System.out.printf(sparse2[i][j] + "\t");
            }
            System.out.println();
        }
    }


    //对稀疏数组的解压
    public static int[][] sparseToArray(int sparse[][]){
        System.out.println("解压后的稀疏数组为：");
        //先初始化一个同样大小的数组
        int arr[][]= new int[sparse[0][0]][sparse[0][1]];

        for (int i = 1; i <= sparse[0][2] ; i++) {
            arr[sparse[i][0]][sparse[i][1]] = sparse[i][2];
        }

        //遍历得到的数组数组
        for (int[] row:arr) {
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        return arr;
    }

}
