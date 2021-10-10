package code.google;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://www.youtube.com/watch?v=Evrdo1JEnmo

/**
 * A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.
 *
 * For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
 * A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.
 *
 * Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.
 *
 * Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.
 */
public class RemoveOuterParenthesis {

    public static void main(String args[]){
        RemoveOuterParenthesis obj = new RemoveOuterParenthesis();
        String str = "(()())(())(()(()))";

        System.out.println(obj.getValidString(str));

    }
    public String getValidString(String str){

        Stack<Character> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);

            if(stack.isEmpty()){
                list.add(i);
                stack.push(c);
                continue;       // this is imp
            }

            if(c=='(' && stack.peek()==')' || (c==')' && stack.peek()=='(')){
                stack.pop();
                if(stack.isEmpty()){
                    list.add(i);
                }
            }
            else{
                stack.push(c);
            }
        }

        StringBuilder builder = new StringBuilder();
        for(int i=0;i<list.size()-1;i+=2){
            builder.append(str.substring(list.get(i)+1,list.get(i+1)));
        }

        return builder.toString();
    }
}
