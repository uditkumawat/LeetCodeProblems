package code.leetcode.doordash;

import java.util.Stack;

//https://www.youtube.com/watch?v=081AqOuasw0
//TC- O(N)
//SC - O(N)  stack size
public class BasicCalculator {

    public static void main(String args[]) {

        String str = "(1+(4+5+2)-3)+(6+8)";

        System.out.println(calculate1(str));

    }

        public static int calculate2(String str){


        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int sign = 1;

        for(int i=0;i<str.length();i++){

            if(isNumber(str.charAt(i))){
                int num = 0;
                while(i<str.length() && isNumber(str.charAt(i))){
                    num = num*10 + str.charAt(i)-'0';
                    i++;
                }
                sum = sum+num*sign;
                i--;
            }
            else if(str.charAt(i)=='+'){
                sign = 1;
            }
            else if(str.charAt(i)=='-'){
                sign = -1;
            }
            else if(str.charAt(i)=='('){
                stack.push(sum);
                stack.push(sign);
                sum = 0;
                sign = 1;
            }
            else if(str.charAt(i)==')'){
                sum = stack.pop()*sum;      // multiplying with last sign
                sum = sum + stack.pop();    // adding last sum
            }
        }

        return sum;
    }

    public static int calculate1(String s) {

        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int sign = 1;

        for(int i=0;i<s.length();i++){

            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                int num = 0;

                while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
                    num = num*10 + s.charAt(i)-'0';
                    i++;
                }
                sum+=num*sign;
                i--;
            }
            else if(s.charAt(i)=='+'){
                sign = 1;
            }
            else if(s.charAt(i)=='-'){
                sign = -1;
            }
            else if(s.charAt(i)=='('){
                stack.push(sum);
                stack.push(sign);
                sum = 0;
                sign = 1;
            }
            else if(s.charAt(i)==')'){
                sum = stack.pop()*sum;
                sum = sum+stack.pop();
            }
        }

        return sum;
    }

    public static boolean isNumber(char c){
        return c>='0' && c<='9';
    }
}
