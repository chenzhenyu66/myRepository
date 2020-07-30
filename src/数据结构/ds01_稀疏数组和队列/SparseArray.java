package 从零开始的数据结构.ds01_稀疏数组和队列;

/**
 * 2020/4/9 10:43
 *
 * @author a1344
 * 说明：将数组转化为稀疏数组，并将稀疏数组转化为普通数组
 *
 * 稀疏数组，第一行存储 几行几列多少有效数据
 * 1.遍历原来的数组，计算有效数据sum
 * 2.根据sum创建稀疏数组
 * 3.将有效数据存到稀疏数组中
 *
 * 解压
 * 根据第一行数据创建一个数组
 * 然后将有效数据写进创建的数组中
 */
public class SparseArray {
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

        //遍历得到稀疏数组，计算数组有几个数
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

        //遍历得到的稀疏数组
        for (int[] row:sparse) {
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        sparseToArray(sparse);

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
