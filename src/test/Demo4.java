package test;

import dataStructure03_简单排序.插入排序.ArrayIns;
import dataStructure03_简单排序.选择排序.ArraySel;
import dataStructure04_栈和队列.中缀转后缀表达式.IntoPost;
import dataStructure04_栈和队列.优先级队列.PriorityQ;
import dataStructure04_栈和队列.分配符匹配.BracketChecker;
import dataStructure04_栈和队列.单词逆序.Reverser;
import dataStructure04_栈和队列.后缀表达式求值.ParsePost;
import dataStructure04_栈和队列.简单的栈.StackX;
import dataStructure04_栈和队列.简单的队列.QueueX;
import org.junit.Test;

import java.util.*;

/**
 * 2020/3/6 9:45
 *
 * @author a1344
 * 说明：
 */
public class Demo4 {
    //选择排序测试
    @Test
    public void Test1() {
        ArrayIns a = new ArrayIns(100);

        a.insert(9);
        a.insert(8);
        a.insert(7);
        a.insert(6);
        a.insert(5);
        a.insert(4);
        a.insert(3);
        a.insert(2);
        a.insert(1);
        a.insertionSort();
        a.display();
    }

    //栈的测试
    @Test
    public void Test2() {
        StackX x = new StackX(10);
        System.out.println(x.toString());
        x.push(1);
        x.push(5);
        x.push(2);
        x.push(3);
        x.push(1);

        System.out.println(x.toString());
        System.out.println("x.peek():" + x.peek());
        System.out.println("x.pop():" + x.pop());
        System.out.println(x.toString());
    }

    //单词逆序测试
    @Test
    public void Test3() {
        Reverser r = new Reverser("我爱你(cnm)");

        System.out.println(r.doRev());
    }

    //分配福匹配测试
    @Test
    public void Test4() {
        BracketChecker bracketChecker = new BracketChecker("(5");
        bracketChecker.check();
    }

    //简单的队列的测试
    @Test
    public void Test5() {
        QueueX queueX = new QueueX(10);
        System.out.println(queueX.isEmpty());
        queueX.insert(1);
        queueX.insert(2);
        queueX.insert(3);
        queueX.insert(4);
        queueX.insert(5);
        queueX.insert(6);
        System.out.println(queueX.size());
        System.out.println(queueX.remove());
        System.out.println(queueX.size());
    }

    //优先级队列测试
    @Test
    public void Test6() {
        PriorityQ q = new PriorityQ(10);
        q.insert(10);
        q.insert(20);
        q.insert(15);
        q.insert(3);
        q.insert(22);
        System.out.println(q.toString());

        q.remove();
        System.out.println(q.toString());

    }


    //中缀表达式转换为后缀表达式
    @Test
    public void Test7() {
        IntoPost i = new IntoPost("(11+12)*5");
        String s = i.doTrans();
        System.out.println(s);
    }

    //后缀表达式测试
    @Test
    public void Test8() {
        ParsePost post = new ParsePost("1112+5*");
        System.out.println(post.doParse());
    }

    @Test
    public void Test9() {
        String str1 = "a";
        String str2 = "b";
        String str3 = "ab";
        String str4 = str1 + str2;
        String str5 = new String("ab");

        System.out.println(str5.equals(str3));
        System.out.println(str5 == str3);
        System.out.println(str5.intern() == str3);
        System.out.println(str5.intern() == str4);

    }

    @Test
    public void Test10() {
        String s = "abc123";
        String s1 = "abc";
        String s2 = "123";

        String s3 = s1 + s2;            //相当于创建了一个StringBuffer调用append()方法进行拼接，但是没有重写equal方法
        String s4 = "abc" + "123";

        System.out.println(s == s3);
        System.out.println(s == s4);

    }

    @Test
    public void Test11() {
        long round = Math.round(11.5);
        long round1 = Math.round(-11.5);

        System.out.println(round);
        System.out.println(round1);
    }

    @Test
    public void Test12() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(2,2);
        map.put(3,2);
    }
    private static void updateList(List list){
        list.remove(2);
    }
}
