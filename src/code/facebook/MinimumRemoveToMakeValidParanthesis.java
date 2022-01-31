package code.facebook;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Algorithm
 *
 * Let's put all this together into a 2-pass algorithm.
 *
 * Identify all indexes that should be removed.
 * Build a new string with removed indexes.
 * As explained above, we should use a stack. If we put the indexes of the "(" on the stack, then we'll know that all the indexes on the stack at the end are the indexes of the unmatched "(". We should also use a set to keep track of the unmatched ")" we come across. Then, we can remove the character at each of those indexes and then return the edited string.
 */
//TC - O(n)
    //SC - O(N)
public class MinimumRemoveToMakeValidParanthesis {

    public static void main(String args[]){
        String s = "lee(t(c)o)de)";

        MinimumRemoveToMakeValidParanthesis obj = new MinimumRemoveToMakeValidParanthesis();

        System.out.println(obj.minRemoveToMakeValid(s));

    }
    public String minRemoveToMakeValid(String s) {

        if(s==null || s.length()==0){
            return s;
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        Set<Integer> indexesToRemove = new HashSet<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.push(i);
            }
            else if(c==')'){
                if(stack.isEmpty()){
                    indexesToRemove.add(i);
                }
                else{
                    stack.pop();
                }
            }
        }

        //case when still open brackets are there
        while(!stack.isEmpty()){
            indexesToRemove.add(stack.pop());
        }

        for(int i=0;i<s.length();i++){
            if(!indexesToRemove.contains(i)){
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
