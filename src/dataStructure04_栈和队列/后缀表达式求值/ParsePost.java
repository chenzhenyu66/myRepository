package dataStructure04_栈和队列.后缀表达式求值;

import java.util.Stack;

/**
 * 2020/3/8 20:31
 *
 * @author a1344
 * 说明：后缀表达式求值
 */
public class ParsePost {
    private Stack<Integer> stack;
    private String input;

    public ParsePost(String input) {
        this.input = input;
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

    public int doParse() {
        stack = new Stack();
        char ch;
        int j;
        int num1, num2, interAns;

        for (j = 0; j < input.length(); j++) {
            ch = input.charAt(j);
            displayStack(" " + ch + " ");
            if (ch >= '0' && ch <= '9'){
                stack.push(ch-'0');
            }else{
                num2 = stack.pop();
                num1 = stack.pop();
                switch (ch){
                    case '+':
                        interAns = num1 +num2;
                        break;
                    case '-':
                        interAns = num1 - num2;
                        break;
                    case '*':
                        interAns = num1 * num2;
                        break;
                    case '/':
                        interAns =num1 / num2;
                        break;
                    default:
                        interAns =0;
                }
                stack.push(interAns);
            }//end else
        }//end for
        interAns =stack.pop();
        return interAns;
    }
}












