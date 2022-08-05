package code.march.challenge;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

//TC - O(N)
//SC - O(N)
//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
//https://www.youtube.com/watch?v=qVBS4IUPeQg
public class MinimumRemoveToMakeParenthesis {

    public static void main(String args[]){

        MinimumRemoveToMakeParenthesis obj = new MinimumRemoveToMakeParenthesis();

        System.out.println(obj.minRemoveToMakeValid("lee(t(c)o)de)"));

        System.out.println(obj.minRemoveToMakeValid("a)b(c)d"));

    }

    public String minRemoveToMakeValid(String str){

        Set<Integer> indexesToRemove = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    indexesToRemove.add(i);
                }
            }
            else if(str.charAt(i)=='('){
                stack.push(i);
            }
        }

        while(!stack.isEmpty()){
            indexesToRemove.add(stack.pop());
        }

        for(int i=0;i<str.length();i++){
            if(!indexesToRemove.contains(i)){
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }
}
