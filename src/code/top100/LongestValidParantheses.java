package code.top100;

import java.util.Stack;

public class LongestValidParantheses {

    public static void main(String args[]){
        String str = "}{}{}}";

        System.out.println(getMaxLength(str));
    }

    public static int getMaxLength(String str){

        int maxLength = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);

            if(c=='{'){
                stack.push(i);
            }
            else{

                stack.pop();

                if(!stack.isEmpty()){
                    maxLength = Math.max(maxLength,i-stack.peek());
                }
                else{
                    stack.push(i);
                }
            }
        }

        return maxLength;
    }

    public int getMaxLengthO1(String str){

        int open = 0;
        int close = 0;
        int maxLength = 0;

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if (c == '{') {
                open++;
            }
            else {
                close++;
            }
            if(open==close){
                maxLength = Math.max(maxLength,open+close);
            }
            else if(close>open){
                open=0;
                close=0;
            }
        }

        open=0;
        close=0;

        for(int i=str.length()-1;i>=0;i--){
            char c = str.charAt(i);
            if (c == '{') {
                open++;
            }
            else {
                close++;
            }
            if(open==close){
                maxLength = Math.max(maxLength,open+close);
            }
            else if(open>close){
                open=0;
                close=0;
            }
        }

        return maxLength;
    }
}
