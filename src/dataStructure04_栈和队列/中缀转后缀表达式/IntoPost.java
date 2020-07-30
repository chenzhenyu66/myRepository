package dataStructure04_栈和队列.中缀转后缀表达式;

import java.util.Stack;

/**
 * 2020/3/6 21:51
 *
 * @author a1344
 * 说明：
 */
public class IntoPost {
    private Stack<Character> stack;
    private String input;
    private String output = "";

    public IntoPost(String input) {
        this.input = input;

        stack = new Stack();
    }

    public void displayStack(String s) {
        System.out.print(s);
        System.out.print("Stack (bottom-->top):");
        for (int j = 0; j < stack.size(); j++) {
            System.out.print(stack.get(j));
            System.out.print(' ');
        }
        System.out.println();
    }

    public String doTrans() {
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            displayStack("For " + ch + " ");
            switch (ch) {
                case '+':
                case '-':
                    gotOper(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOper(ch, 2);
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    gotParen(ch);
                    break;
                default:
                    output = output + ch;
                    break;
            }//end switch
        }//end for
        while (!stack.isEmpty()){
            displayStack("While ");
            output = output +stack.pop();
        }
        displayStack("End ");
        return output;
    }

    private void gotParen(char ch) {
        while (!stack.isEmpty()){
            char chx = stack.pop();
            if (chx =='(')
                break;
            else
                output = output+chx;
        }
    }

    private void gotOper(char opThis, int prec1) {
        while (!stack.isEmpty()) {
            char opTop = stack.pop();
            if (opTop == '(') {
                stack.push(opTop);
                break;
            } else {
                int prec2;

                if (opTop == '+' || opTop == '-') {
                    prec2 = 1;
                } else {
                    prec2 = 2;
                }

                if (prec2 < prec1) {
                    stack.push(opTop);
                    break;
                } else {
                    output = output + opTop;
                }
            }//end else
        }//end while
        stack.push(opThis);
    }
}
