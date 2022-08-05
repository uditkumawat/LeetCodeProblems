package code.feb.challenge;

import java.util.Stack;

//https://www.youtube.com/watch?v=3QJzHqNAEXs
//TC - O(N)
//SC - O(N)
//https://leetcode.com/problems/remove-k-digits/
public class RemoveKDigits {

    public static void main(String args[]){

        String num = "10";
        int k = 2;

        RemoveKDigits obj = new RemoveKDigits();

        System.out.println(obj.removeKdigits(num,k));
    }
    public String removeKdigits(String num, int k) {

        if(k==0){
            return num;
        }

        if(k==num.length()){
            return "0";
        }

        Stack<Character> stack = new Stack<>();

        int index=0;

        while(index<num.length()){

            char c = num.charAt(index);

            while(k>0 && !stack.isEmpty() && stack.peek()>=c){
                k--;
                stack.pop();
            }

            stack.push(c);
            index++;
        }

        //this will remove the larger element from back only if k is not zero
        while(k>0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        sb.reverse();

        while(sb.length()>0 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }

        return sb.length()>0?sb.toString():"0";
    }
}
