package dataStructure04_栈和队列.后缀表达式求值;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;;

/**
 * 中缀表达式转后缀表达式并且计算其值
 */
public class ParsePost2 {
    private static Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('+', 0);
        map.put('-', 0);
        map.put('*', 1);
        map.put('/', 1);
    }

    private static List<String> toPost(String target) {
        List<String> post = new ArrayList<>();
        Stack<Character> stk = new Stack<>();

        Pattern p = Pattern.compile("\\d+|\\D");
        Matcher m = p.matcher(target);
        while (m.find()) {
            String e = m.group();
            if (e.matches("\\d+"))
                post.add(e);
            else if (e.equals("("))
                stk.push('(');
            else if (e.equals(")")) {
                while (stk.peek() != '(')
                    post.add(stk.pop() + "");
                stk.pop();
            } else {
                char op = e.charAt(0);
                while (!stk.isEmpty() && stk.peek() != '('
                        && map.get(op) <= map.get(stk.peek()))
                    post.add(stk.pop() + "");
                stk.push(op);
            }
        }
        while (!stk.isEmpty()) post.add(stk.pop() + "");
        return post;
    }

    private static int calcuPost(List<String> post) {
        Stack<Integer> stk = new Stack<>();
        for (String s : post) {
            if (s.matches("\\d+")) stk.push(Integer.parseInt(s));
            else {
                char c = s.charAt(0);
                int b = stk.pop();
                int a = stk.pop();
                int t = 0;
                if (c == '+')
                    t = a + b;
                else if (c == '-')
                    t = a - b;
                else if (c == '*')
                    t = a * b;
                else
                    t = a / b;
                stk.push(t);
            }
        }
        return stk.pop();
    }

    public static void main(String[] args) {

        Scanner is = new Scanner(System.in);
        while (is.hasNext()) {
            String exp = is.next();
            System.out.println(calcuPost(toPost(exp)));

        }
        is.close();
    }

}