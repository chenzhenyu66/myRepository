package test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 2020/7/6 17:20
 *
 * @author a1344
 * 说明：
 */
public class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> deque;

    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        if (queue.isEmpty()) {

            return -1;
        }
        return 0;
    }

    public void push_back(int value) {
        queue.add(value);

    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int pop = queue.poll();

        return pop;
    }

    @Test
    public void maxQueueTest() {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(92);
        maxQueue.push_back(73);
        maxQueue.push_back(69);
        maxQueue.push_back(77);
        maxQueue.push_back(77);
        maxQueue.push_back(67);
        maxQueue.push_back(78);
        maxQueue.push_back(27);

        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());


//        for (int i = 0; i < 20; i++) {
//            System.out.print(maxQueue.stack[i]);
//            System.out.print("\t");
//        }

    }

    public String reverseLeftWords(String s, int n) {
//        char[] chars = s.toCharArray();
//        int len = chars.length;
//        chars = Arrays.copyOf(chars, chars.length + n);
//        for (int i = 0; i < n; i++) {
//            chars[len + i] = chars[i];
//        }
//        chars = Arrays.copyOfRange(chars,n,chars.length);
//        return String.valueOf(chars);
        return s.substring(n, s.length()) + s.substring(0, n);
    }

    @Test
    public void reverseLeftWordsTest() {
        String a = reverseLeftWords("abcdefg", 2);
        System.out.println(a);
    }

    public int[] printNumbers(int n) {
        n = (int) Math.pow(10, n) - 1;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        return nums;
    }

    @Test
    public void printNumbersTest() {
        int[] ints = printNumbers(3);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = mirrorTree(root.right);
        TreeNode right = mirrorTree(root.left);
        root.left = left;
        root.right = right;
        return root;
    }

    @Test
    public void mirrorTreeTest() {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        root1.right = root3;
        root1.left = root2;

        TreeNode treeNode = mirrorTree(root1);
        System.out.println(treeNode);
    }

    public int maxDepth(TreeNode root) {
        return maxDepth(root, 1);
    }

    private int maxDepth(TreeNode root, int i) {
        if (root == null) return i - 1;
        int i1 = maxDepth(root.left, i + 1);
        int i2 = maxDepth(root.right, i + 1);
        return Math.max(i1, i2);
    }

    @Test
    public void maxDepthTest() {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        root1.right = root3;
        root1.left = root2;

        int i = maxDepth(root1);
        System.out.println(i);
    }

    public ListNode reverseList(ListNode head) {
        ListNode node = new ListNode(-1);
        ListNode temp = null;
        while (head != null) {
            node.next = head;
            head = head.next;
            node.next.next = temp;
            temp = node.next;
        }
        return node.next;
    }

    @Test
    public void reverseListTest() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(reverseList(node1));
    }

    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        s = s.trim();
        String[] words = s.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].equals("")) continue;
            if (i != 0)
                builder.append(words[i]+" ");
            else
                builder.append(words[i]);
        }
        return builder.toString();
    }
    @Test
    public void reverseWordsTest(){
        System.out.println(reverseWords("the  sky is blue"));
    }
}
