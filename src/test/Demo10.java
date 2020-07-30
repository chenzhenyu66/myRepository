package test;

import org.junit.Test;

import java.math.BigInteger;
import java.security.KeyPair;
import java.util.*;

/**
 * 2020/6/27 18:57
 *
 * @author a1344
 * 说明：
 */
public class Demo10 {
    Stack<Integer> A, B;

    /**
     * 剑指Offer-09:两个栈实现一个队列
     * Demo10()
     * appendTail()
     * deleteHead()
     * 1.栈A，只支持插入操作
     * 2.栈B. 删除操作
     * 删除前，首先判断B是否为空，
     * 不为空，返回B的栈顶的数
     * 为空，将A中的数导入到B中，然后返回B栈顶的数
     */
    public Demo10() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void appendTail(int value) {
        A.add(value);
    }

    public int deleteHead() {
        //首先先判断B是否为空，B不空的话，直接返回B的栈顶
        //如果为空，则将A中所有数据导入B
        if (!B.isEmpty())
            return B.pop();
        if (A.isEmpty())
            return -1;
        while (!A.isEmpty()) {
            B.add(A.pop());
        }

        return B.pop();
    }

    /**
     * 剑指Offer-10-1 斐波那契数列
     * 动态规划法(也可以用递归法，但是递归效率低)
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        int i1 = 1, i2 = 1, count = 0;

        if (n == 0) return 0;
        if (n <= 2) return 1;

        for (int i = 2; i < n; i++) {
            count = (i1 + i2) % 1000000007;
            i1 = i2;
            i2 = count;
        }
        return count;
    }

    @Test
    public void fibTest() {
        int[] ii = {1, 2, 3};
        System.out.println(ii.length);
    }

    /**
     * 剑指Offer-03 数组中重复的数
     * 可以利用set集合，set集合有去重的功能
     * 当添加不进去set时，即为重复的数据
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        int target = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                target = num;
            }
        }
        return target;
    }

    @Test
    public void findRepeatNumberTest() {
        int[] nums = {1, 2, 3, 4, 4, 5, 6, 6};
        System.out.println(findRepeatNumber(nums));
    }

    /**
     * 剑指Offer-04 二维数组中的查找
     * 方法一：暴力，不推荐
     * 方法二：线性查找
     * 选取左上或者右下为起点
     * 以左上为例：
     * 当target > 选取点,下移
     * 当target < 选取点,左移
     * 当target = 选取点,返回true
     * 没找到,返回false
     *
     * @param matrix 一个二维数组(从左到右依次增大，从上到下依次增大)
     * @param target 要查找的目标数
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int n = 0;
        int m = matrix[0].length - 1;
        while (n < matrix.length && m >= 0) {
            if (target > matrix[n][m]) {
                n++;
            } else if (target == matrix[n][m]) {
                return true;
            } else if (target < matrix[n][m]) {
                m--;
            }
        }
        return false;
    }

    @Test
    public void findNumberIn2DArrayTest() {
        int[][] ii = {{1, 1}};
        System.out.println(findNumberIn2DArray(ii, 1));
    }


    /**
     * eg.[3,4,5,1,2] 为旋转数组
     * 剑指Offer-11 旋转数组中最小的数字
     * 方法一：暴力遍历(X)
     * 方法二：二分查找法
     * 头指针在数组首i，尾指针在数组末j
     * 然后拿到mid=i+j/2
     * 当num[mid]比num[j]的数大时，意味着mid前面的数全都不是需要的结果 i = m+1
     * 当num[mid]比num[j]的数小时，意味着mid后面的数都不是需要的结果 j = m
     * 直到j = i 时，退出循环，返回结果
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else j--;
        }
        return numbers[i];
    }


    @Test
    public void minArrayTest() {
        int[] i = {5, 6, 7, 8, 9, 4};
        System.out.println(minArray(i));
    }

    /**
     * 剑指Offer-12 矩阵中的路径(在一个字符数组中,是否有一条路径能够组成目标字符串)
     * 输入：一个字符数组，一个目标word
     * 输出：是否存在
     * <p>
     * 解题方法：深度优先搜索
     * 首先将字符串转换为字符数组
     * 1.判断是否越界，是否满足拿到的字符是否为目标字符
     * 2.满足上述条件后，判断是否找到了word底部，找到返回true
     * 3.对已经找到的数先用 '\'符号标记,避免重复查找，并临时存储找到的数
     * 4.进行上下左右递归查找
     * 5.回溯  将'\'变回原来的数
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != words[k]) return false;
        if (k == words.length - 1) return true;
        char temp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, words, i + 1, j, k + 1) ||
                dfs(board, words, i - 1, j, k + 1) ||
                dfs(board, words, i, j + 1, k + 1) ||
                dfs(board, words, i, j - 1, k + 1);
        board[i][j] = temp;
        return res;
    }

    @Test
    public void existTest() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'F'}
        };
        System.out.println(exist(board, "BCCEC"));
    }


    /**
     * 剑指Offer-05 替换空格
     * 输入：一个字符串
     * 输出：将字符串中的所有的空格替换为"%20"
     * 方法一：
     * s.replace(" ","%20");
     * 方法二：
     * 先创建一个字符数组，申请最大空间 s.length() * 3
     * 遍历一遍字符数组，当c == ' '时，添加为 "%20"
     * 否则，添加为原字符
     *
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
//        return s.replace(" ","%20");
        int length = s.length();
        char[] chars = new char[length * 3];
        int size = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                chars[size++] = '%';
                chars[size++] = '2';
                chars[size++] = '0';
            } else {
                chars[size++] = c;
            }
        }

        return new String(chars, 0, size);
    }

    @Test
    public void replaceSpaceTest() {
        System.out.println(replaceSpace("We are happy."));
    }

    /**
     * 剑指Offer-06 从尾到头打印链表
     * 输入：一个单链表
     * 输出：一个数组，该数组保存了链表的倒叙信息
     * <p>
     * 方法一：反转链表，然后遍历存入(X)
     * 方法二：利用栈的入栈和出栈(✔)
     * 方法三：遍历一遍链表，拿到链表的长度，然后创建合适的数组
     * 在遍历一次，按需存入即可(✔)
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        int temp = 0;
        while (head != null) {
            stack.add(head.val);
            head = head.next;
            temp++;
        }
        int[] nodesVal = new int[temp];
        temp = 0;
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            nodesVal[temp++] = pop;
        }
        return nodesVal;
    }

    @Test
    public void reversePrintTest() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        int[] ints = reversePrint(node1);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    /**
     * 剑指Offer-25：合并两个有序链表
     * 输入：两个有序链表
     * 输出：一个合并后的有序链表
     * 方法：
     * 伪头结点法(穿针引线法)
     * 设置一个头结点pre，两个链表l1,l2
     * 比较l1.val,l2.val的值，pre指向小的
     * 递归法()
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(-1);
        ListNode pre = node;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                pre.next = l2;
                l2 = l2.next;
            } else {
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return node.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l2 == null ? l1 : l2;
        ListNode first = l1.val > l2.val ? l2 : l1;
        first.next = mergeTwoLists2(first.next, first == l1 ? l2 : l1);

        return first;
    }

    @Test
    public void mergeTwoListsTest() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node4.next = node5;
        node5.next = node6;
        System.out.println(mergeTwoLists2(node1, node4));
    }

    /**
     * 剑指Offer-15 二进制中一的个数
     * 输入：一个二进制数
     * 输出：二进制中一的个数
     * 方法1:逐位判断
     * 逐位与 1 尾位数为1结果为1，尾位数为0，结果为0
     * <p>
     * 方法2：n & (n-1)
     * 循环几次为结果0，则二进制中1的个数就是几次
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    @Test
    public void hammingWeightTest() {
        System.out.println(hammingWeight(00000000000000000000000010000000));

    }

    /**
     * 剑指Offer-13 机器人的运动范围
     * 输入：二维数组的长宽，和限制条件k
     * 输出：机器人从[0,0]开始走，计算能到达的位置个数
     * <p>
     * 方法一：深度优先搜索
     * 第一步：构建m*n的二维数组,将机器人当前坐标，数组长宽,限制条件,二维数组全部传入
     * 第二步：限制递归条件(不能越界，不能超过限定条件，不能算入已访问的)
     * 第三步：访问过的设置标记，返回1+递归()  1为当前位置
     * 递归(上下左右)
     * <p>
     * 方法二：广度优先搜索
     * 设置一个队列，
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return movingCount(0, 0, m, n, k, visited);
    }

    private int movingCount(int i, int j, int m, int n, int k, boolean[][] visited) {
        if (i < 0 || j < 0 || m <= i || n <= j || intSum(i, j) > k || visited[i][j] == true)
            return 0;
        visited[i][j] = true;
        return 1 + movingCount(i + 1, j, m, n, k, visited) +
                movingCount(i - 1, j, m, n, k, visited) +
                movingCount(i, j + 1, m, n, k, visited) +
                movingCount(i, j - 1, m, n, k, visited);
    }

    private int intSum(int m, int n) {
        int a = 0, b = 0, sum = 0;
        a = m % 10;
        b = m / 10;
        sum = a + b;
        a = n % 10;
        b = n / 10;
        sum = sum + a + b;
        return sum;
    }


    @Test
    public void movingCountTest() {
        System.out.println(movingCount(15, 15, 8));
    }


    /**
     * 剑指Offer-07 重建二叉树
     * 输入：一个前序表达式 一个中序表达式
     * 输出：一个二叉树
     * 第一步：将中序表达式 以值，索引的形式存入HashMap中
     * 第二步：拿到前序的首节点，找到在中序的索引位置，左边为其左子树，右边为其右子树
     * 第三步：递归构造子树
     * 第四步：回溯构造二叉树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> indexMap = new HashMap<>();
        int length = preorder.length;
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, length - 1, inorder, 0, length - 1, indexMap);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap) {
        if (preorderStart > preorderEnd) {
            return null;
        }
        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);

        if (preorderStart != preorderEnd) {
            int rootIndex = indexMap.get(rootVal);
            int leftNodes = rootIndex - inorderStart, rightNodes = inorderEnd - rootIndex;
            TreeNode leftSubtree = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, inorderStart, rootIndex - 1, indexMap);
            TreeNode rightSubtree = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
            root.left = leftSubtree;
            root.right = rightSubtree;
        }

        return root;
    }

    @Test
    public void buildTreeTest() {
        int[] pre = {1, 2, 3, 4, 5, 6, 7};
        int[] ino = {3, 2, 4, 1, 6, 5, 7};
        TreeNode treeNode = buildTree(pre, ino);
        System.out.println(treeNode);
    }


    @Test
    public void test01() {
        String s1 = "hello";
        String s2 = "aello";
        String s3 = new String("hello");

//        System.out.println(s1 == s2);
//        System.out.println(s1 == s3);
//        System.out.println(s1.equals(s3));

        System.out.println(s1.replace("l", "L"));
        System.out.println(s1.replaceAll("l", "L"));
        System.out.println(s1.compareTo(s2));
    }

    public int Fun(int num, int n) {
        return (int) (Math.pow(n / num + 1, n % num) * Math.pow(n / num, num - n % num));
    }

    public int cuttingRope(int n) {
        int[] ans = new int[1001];
        ans[2] = 1;
        int cut = 2;
        for (int i = 3; i <= 58; i++) {
            int res1 = Fun(cut, n);
            int res2 = Fun(cut + 1, n);
            if (res1 <= res2) {
                cut++;
            }
            ans[i] = res1 > res2 ? res1 : res2;
        }
        return ans[n] % 1000000007;
    }

    public int cuttingRope2(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int mod = (int) 1e9 + 7;
        long res = 1;
        while (n > 4) {
            res *= 3;
            res %= mod;
            n -= 3;
        }
        return (int) (res * n % mod);
    }


    @Test
    public void cuttingRopeTest() {
        System.out.println(cuttingRope2(120));
    }

    public int getDigit(int number) {
        int temp = 0;
        while (number > 0) {
            temp++;
            number = number / 10;
        }
        return temp;
    }

    public int countDigitOne(int n) {
        int num = getDigit(n);
        int temp = 0;
        for (int i = 1; i <= n; i++) {
        }
        return temp;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        //默认是小顶堆
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num : arr) {
            if (pq.size() < k)
                pq.offer(num);
            else if (pq.peek() > num) {
                pq.poll();
                pq.offer(num);
            }
        }

        int[] res = new int[pq.size()];
        int index = 0;
        for (int i : pq) {
            res[index++] = i;
        }
        return res;
    }

    @Test
    public void getLeastNumbersTest() {
        int[] a = {5, 4, 3, 2, 1};
        int[] leastNumbers = getLeastNumbers(a, 3);
        for (int i : leastNumbers) {
            System.out.println(i);
        }
    }

    public int sumNums(int n) {
        if (n == 1)
            return 1;
        return sumNums(n - 1) + n;
    }

    @Test
    public void sumNumsTest() {
        System.out.println(sumNums(100));
    }

    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }


    @Test
    public void singleNumberTest() {
//        System.out.println(getOneBinary(7));
//        int[] nums = {7, 6, 6, 6};
//        singleNumber(nums);
//        String s ="123";
//        String[] stringArray = new String[3]; // 各元素的值默认为null
//        for (int i = 0; i < stringArray.length; i++) { // 对各元素进行初始化，但没有赋值。
//            stringArray[i] = new String();
//            System.out.println(stringArray[i]);
//        }
        System.out.println(Math.round(-1.5));
        String s ="";

    }
    @Test
    public void Test6(){
        Integer a = 3;
        Integer b = 5;
        swap(a,b);
        System.out.println(a);
        System.out.println(b);
    }
    public void swap(int a,int b){
        Integer c = 0;
        c = a;
        a = b;
        b = c;
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "[val=" + val +
                ", left=" + left +
                ", right=" + right + "]";
    }
}







