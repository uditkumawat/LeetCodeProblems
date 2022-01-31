package code.facebook;

import java.util.Stack;

public class DecodeString {

    public static void main(String args[]){
        String str = "2[abc3[cd]ef]";

        DecodeString obj = new DecodeString();

        System.out.println(obj.decodeString(str));

    }
    public String decodeString(String s) {

        if(s==null || s.length()==0){
            return null;
        }

        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numberStack = new Stack<>();

        StringBuilder curr = new StringBuilder();

        int num = 0;

        for(char c:s.toCharArray()){
            if(isNumber(c)){
                num = num*10+c-'0';
            }
            else if(isAlphabet(c)){
                curr.append(c);
            }
            else if(c=='['){
                numberStack.push(num);
                strStack.push(curr);
                num = 0;
                curr = new StringBuilder();
            }
            else if(c==']'){
                StringBuilder newStr = curr;
                int freq = numberStack.pop();
                curr = strStack.pop();
                while(freq-->0){
                    curr.append(newStr);
                }
                num = 0;
            }
        }

        return curr.toString();
    }

    boolean isNumber(char c){
        return c>='0' && c<='9';
    }

    boolean isAlphabet(char c){
        return c>='a' && c<='z';
    }
}
