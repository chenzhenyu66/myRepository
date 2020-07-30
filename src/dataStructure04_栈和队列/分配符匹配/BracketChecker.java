package dataStructure04_栈和队列.分配符匹配;

import java.util.Stack;

/**
 * 2020/3/6 11:09
 *
 * @author a1344
 * 说明：如果是这些符号 ({[ 放到栈中
 *      如果是 ]})这些符号我们删除上一个放到栈中的数据，比较下是否匹配，不匹配返回错误
 *      如果全部匹配的话，我们的栈应该是空的
 */
public class BracketChecker {
    private String input;

    public BracketChecker(String in) {
        input = in;
    }

    public void check() {
        Stack<Character> stack = new Stack();
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    stack.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!stack.isEmpty()) {
                        char pop = stack.pop();
                        if ((ch == '}' && pop != '{') ||
                                (ch == ']' && pop != '[') ||
                                (ch == ')' && pop != '('))
                            System.out.println("you have a Error:" + ch + " at " + j);
                    } else {
                        System.out.println("you have a Error:" + ch + " at " + j);
                    }
                    break;
            }//end switch
        }//end for

        if (!stack.isEmpty())
            System.out.println("you have a wrong");
    }
}
