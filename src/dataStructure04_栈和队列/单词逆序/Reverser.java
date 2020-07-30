package dataStructure04_栈和队列.单词逆序;


import java.util.Stack;

/**
 * 2020/3/6 10:47
 *
 * @author a1344
 * 说明：单词逆序
 */
public class Reverser {
    private String input;
    private String output;

    public Reverser(String input){
        this.input =input;
    }
    public String doRev(){

        Stack<Character> x = new Stack<>();

        for (int j = 0;j<input.length();j++){
            char ch = input.charAt(j);
            x.push(ch);
        }
        output ="";
        while (!x.isEmpty()){
            char ch = x.pop();
            output = output+ch;
        }
        return output;
    }
}
