package test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 2020/6/24 21:52
 *
 * @author a1344
 * 说明：
 */
public class Demo8 {
    public static void main(String[] args) {
        ListNode tempNode1 = new ListNode(1);
        ListNode tempNode2 = new ListNode(2);
        ListNode tempNode3 = new ListNode(3);
        tempNode1.next = tempNode2;
        tempNode2.next = tempNode3;

        ListNode tempNode21 = new ListNode(3);
        ListNode tempNode22 = new ListNode(4);
        ListNode tempNode23 = new ListNode(5);
        tempNode21.next = tempNode22;
        tempNode22.next = tempNode23;

//        ListNode listNode = mergeTwoLists(tempNode1, tempNode21);
//        System.out.println(listNode);
        ListNode tempNode31 = new ListNode(2);
        ListNode tempNode32 = new ListNode(4);
        ListNode tempNode33 = new ListNode(7);
        tempNode31.next = tempNode32;
        tempNode32.next = tempNode33;
        ListNode[] lists = {tempNode1, tempNode21, tempNode31};

        ListNode listNode = mergeKLists(lists);
        System.out.println(listNode);
    }

    /**
     * 主要测试swapPairs()方法
     */
    @Test
    public void Test1() {
        ListNode tempNode1 = new ListNode(1);
        ListNode tempNode2 = new ListNode(2);
        ListNode tempNode3 = new ListNode(3);
        ListNode tempNode4 = new ListNode(4);
        ListNode tempNode5 = new ListNode(5);
        tempNode1.next = tempNode2;
        tempNode2.next = tempNode3;
        tempNode3.next = tempNode4;
        tempNode4.next = tempNode5;
        ListNode listNode = swapPairs(tempNode1);
        System.out.println(listNode);
    }

    @Test
    public void Test2() {
        ListNode tempNode1 = new ListNode(1);
        ListNode tempNode2 = new ListNode(2);
        ListNode tempNode3 = new ListNode(3);
        ListNode tempNode4 = new ListNode(4);
        ListNode tempNode5 = new ListNode(5);
        ListNode tempNode6 = new ListNode(6);
        ListNode tempNode7 = new ListNode(7);
        tempNode1.next = tempNode2;
        tempNode2.next = tempNode3;
        tempNode3.next = tempNode4;
        tempNode4.next = tempNode5;
        tempNode5.next = tempNode6;
        ListNode listNode = reverseKGroup(tempNode1, 3);
        System.out.println(listNode);
    }

    /**
     * 这个方法就想是一根针将有序的链表穿在一起一样，非常神奇
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tempNode = new ListNode(-1);
        ListNode prev = tempNode;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return tempNode.next;
    }

    /**
     * 将n个有序链表合在一起
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode tempListNode = new ListNode(-1);
        ListNode prev = tempListNode;
        for (int i = 0; i < lists.length; i++) {
            prev.next = mergeTwoLists(prev.next, lists[i]);
        }
        return tempListNode.next;
    }

    /**
     * 两两交换链表中的节点
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tempNode = new ListNode(-1);
        ListNode nextHead = head.next;
        ListNode prev = tempNode;
        prev.next = head;

        int tempIndex = 2;

        while (nextHead != null) {

            if (tempIndex == 2) {
                head.next = nextHead.next;
                prev.next = nextHead;
                nextHead.next = head;
                tempIndex = 0;
            }
            prev = prev.next;
            head = prev.next;
            nextHead = prev.next.next;
            tempIndex++;

        }

        return tempNode.next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        ListNode dummy1 = dummy;
        ListNode tempNode;
        ListNode tempNode2;

        while (true) {

            int i = 1;
            tempNode = head;
            while (k > i && head.next != null) {
                head = head.next;
                i++;
            }

            if (head.next == null && i == k) {
                dummy1.next = reverseList(tempNode);
                break;
            } else if (head.next == null && i != k) {
                dummy1.next = tempNode;
                break;
            }
            tempNode2 = head.next;
            head.next = null;
            tempNode = reverseList(tempNode);
            dummy1.next = tempNode;
            while (dummy1.next != null) {
                dummy1 = dummy1.next;
            }
            head = tempNode2;
        }
        return dummy.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode pCur = head;
        while (pCur != null) {
            ListNode pNex = pCur.next;
            pCur.next = dummy.next;
            dummy.next = pCur;
            pCur = pNex;
        }
        return dummy.next;
    }

    /**
     * 动态规划方法：求字符串的编辑
     * 输入：两个字符串
     * 输出：第一个字符串变为第二个字符串的最小步骤(增、删、改)
     * dp[i - 1][j - 1] + 1   更新
     * dp[i - 1][j] + 1)      删除
     * dp[i][j - 1] + 1       插入
     * @param s1
     * @param s2
     * @return
     */
    public int minDistance(String s1, String s2) {
        char[] word1 = s1.toCharArray();
        char[] word2 = s2.toCharArray();
        int row = s1.length();
        int col = s2.length();
        int[][] dp = new int[row + 1][col + 1];

        for (int i = 1; i <= row; i++)
            dp[i][0] = i;
        for (int j = 1; j <= col; j++)
            dp[0][j] = j;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (word1[i - 1] == word2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1] + 1, dp[i - 1][j] + 1), dp[i][j - 1] + 1);
            }
        }
        for (int i = 0; i <dp.length ; i++) {
            for (int j = 0; j <dp[0].length ; j++) {
                System.out.print(dp[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
        return dp[row][col];
    }

    @Test
    public void test1() {
        String s1 = "abcde";
        String s2 = "abc";
        int i = minDistance(s1, s2);
        System.out.println(i);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + "---" + next;
    }
}
