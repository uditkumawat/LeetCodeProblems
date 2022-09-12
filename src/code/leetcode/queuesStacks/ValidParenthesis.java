package code.leetcode.queuesStacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

    Map<Character,Character> map = new HashMap();

    public boolean isValid(String s) {

        if(s==null || s.length()==0){
            return true;
        }

        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        Stack<Character> stack = new Stack<Character>();

        for(int i=0;i<s.length();i++){

            char c = s.charAt(i);

            if(c=='{' || c=='[' || c=='('){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                else{
                    char topElement = stack.peek();

                    if(!isMatching(topElement,c)){
                        return false;
                    }
                    else{
                        stack.pop();
                    }
                }
            }
        }

        return stack.isEmpty();
    }

    public boolean isMatching(char c1,char c2){

        char c = map.get(c2);
        return c==c1;
    }
}
