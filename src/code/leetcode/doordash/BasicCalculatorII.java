package code.leetcode.doordash;

import java.util.Stack;

//TC - O(N)
//SC - O(1)
public class BasicCalculatorII {

    public static void main(String args[]) {

        String str = "3+5/2";
        System.out.println(calculate(str));
    }

        public int calculateStack(String str){

        Stack<Integer> stack = new Stack<>();
        int curr = 0;
        char op = '+';

        for(int i=0;i<str.length();i++){

            if(isNumber(str.charAt(i))){
                int num = 0;
                while(i<str.length() && isNumber(str.charAt(i))){
                    num = num*10 + str.charAt(i)-'0';
                    i++;
                }
                curr = num;
                i--;
            }

            if(!isNumber(str.charAt(i)) && str.charAt(i)!=' ' || i==str.length()-1){

                if(op=='+'){
                    stack.push(curr);
                }
                else if(op=='-'){
                    stack.push(-curr);
                }
                else if(op=='*'){
                    stack.push(stack.pop()*curr);
                }
                else if(op=='/'){
                    stack.push(stack.pop()/curr);
                }
                op = str.charAt(i);
                curr = 0;
            }
        }

        int sum = 0;
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }

        return sum;
    }

    public static int calculate(String s) {

        if(s==null || s.length()==0){
            return 0;
        }

        int lastNumber = 0;
        int currentNumber = 0;
        char op = '+';
        int result = 0;

        for(int i=0;i<s.length();i++){

            char c = s.charAt(i);
            if(c>='0' && c<='9'){
                currentNumber = currentNumber*10 + c-'0';
            }

            if(!(c>='0' && c<='9') && c!=' ' || i==s.length()-1){

                if(op=='+' || op=='-'){
                    result += lastNumber;
                    lastNumber = op=='+'?currentNumber:-currentNumber;
                }
                else if(op=='*'){
                    lastNumber = lastNumber*currentNumber;
                }
                else if(op=='/'){
                    lastNumber = lastNumber/currentNumber;
                }
                op = c;
                currentNumber = 0;
            }
        }

        result = result+lastNumber;
        return result;
    }

    public static boolean isNumber(char c){
        return c>='0' && c<='9';
    }
}
