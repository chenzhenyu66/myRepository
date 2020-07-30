package 从零开始的数据结构.ds10_二叉树;

/**
 * 2020/6/3 23:19
 *
 * @author a1344
 * 说明：顺序存储二叉树
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrBinaryTree tree = new ArrBinaryTree(arr);
        tree.buildArrBinaryTree();



    }
}

class ArrBinaryTree {
    private HeroNode2 root;
    private int arr[];

    public ArrBinaryTree(int arr[]) {

        this.arr = arr;
    }


    public void buildArrBinaryTree() {
        this.buildArrBinaryTree(0);
    }

    public void buildArrBinaryTree(int index) {
        //如果数组为空，或者arr.length = 0
        if(arr == null || arr.length == 0) { System.out.println("数组为空，不能按照二叉树的前序遍历"); }
        //输出当前这个元素
        //System.out.println(arr[index]);


        //向左递归遍历
        if((index * 2 + 1) < arr.length) {
            buildArrBinaryTree(2 * index + 1 );
        }
        //向右递归遍历
        if((index * 2 + 2) < arr.length) {
            buildArrBinaryTree(2 * index + 2);
        }


    }
}

class HeroNode2 {
    private Integer no;

    private HeroNode2 left;
    private HeroNode2 right;

    public HeroNode2(Integer no) {
        this.no = no;

    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public HeroNode2 getLeft() {
        return left;
    }

    public void setLeft(HeroNode2 left) {
        this.left = left;
    }

    public HeroNode2 getRight() {
        return right;
    }

    public void setRight(HeroNode2 right) {
        this.right = right;
    }



    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                '}';
    }
}
