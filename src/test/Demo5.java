package test;

import org.junit.Test;

/**
 * 2020/3/8 21:09
 *
 * @author a1344
 * 说明：
 */
public class Demo5 {

    @Test
    public void Test1() {
        Person p = new Person(1);
        Person temp = p;
        temp.no = 2;
        System.out.println(temp.no);
        System.out.println(p.no);
    }

    @Test
    public void Test2() {
//        System.out .println(3+4+"Hello");
//        System.out.println("Hello!"+3+4);
        short s = 5;
//        s = s -2;
        byte a = 1;
        short b;
//        b= s+a;
    }

    @Test
    public void Test3() {
        int a = 5 % -3;
        int b = -5 % 3;
        System.out.println(a);
        System.out.println(b);

//        int x=3510;
//        x=x/1000*1000;
//        System.out.println(x);
        int x = 153;
        int a1 = x / 100;
        int a2 = (x - a1 * 100) / 10;
        System.out.println(a1);
        System.out.println(a2);
    }
    @Test
    public void Test4() {
        boolean x = true;
        boolean y = false;
        short z = 42;
        //if(y == true)
        if ((z++ == 42) && (y = true)) z++;

        if ((x = false) || (++z == 45)) z++;

        System.out.println("z = "+ z);
    }
}

class Person {
    protected Integer no;

    public Person(Integer no) {
        this.no = no;
    }
}
