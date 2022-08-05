package code.booking.com;

import java.util.Stack;

//https://leetcode.com/problems/backspace-string-compare/solution/
public class BackStringCompare {

    public static void main(String args[]){

        String s1 = "a#c";
        String s2 = "A#@BB#E#F";

        BackStringCompare obj = new BackStringCompare();

        String s3 = obj.updatedString(s1);
        String s4 = obj.updatedString(s2);

        System.out.println(s3);
        System.out.println(s4);

        if(s3.equals(s4)){

            System.out.println("Matched");
        }
        else{
            System.out.println("Not matched");
        }

    }

    public String updatedString(String s){

        Stack<Character> stack = new Stack<>();
        char lastPopped = '\0';

        for(char c:s.toCharArray()){
            if(c=='#'){
                if(!stack.isEmpty()){
                    lastPopped = stack.pop();
                }
            }
            else if(c=='@'){
                stack.push(lastPopped);
                lastPopped = '\0';
            }
            else{
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
