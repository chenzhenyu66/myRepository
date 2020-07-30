package test;

/**
 * 2020/4/21 20:15
 *
 * @author a1344
 * 说明：lambda
 * 1.需要一个接口
 * 2.然后创建一个接口对象 然后用lambda表达式使用
 */
public class Java8Tester {
    public static void main(String args[]) {
        Java8Tester tester = new Java8Tester();
        A a1 = (a, b) -> a + b;

        System.out.println(a1.add(3, 5));
    }

    interface A {
        int add(int a, int b);
    }

    interface B {

    }


}
