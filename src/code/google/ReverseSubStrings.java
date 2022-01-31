package code.google;

import java.util.Stack;

public class ReverseSubStrings {

    public static void main(String args[]){

        String s = "(ed(et(oc))el)";

        ReverseSubStrings obj = new ReverseSubStrings();

        System.out.println(obj.reverseParentheses(s));

    }
    public String reverseParentheses(String s) {

        StringBuilder sb = new StringBuilder();
        Stack<StringBuilder> stack = new Stack<>();
        stack.push(new StringBuilder());

        for(char c:s.toCharArray()){

            if(c=='('){
                stack.push(sb);
                sb = new StringBuilder();
            }
            else if(c==')'){
                StringBuilder current = sb;
                StringBuilder temp = stack.pop();
                temp.append(current.reverse());
                sb = temp;
            }
            else{
                sb.append(c);
            }
        }

        return sb.toString();

    }
}
