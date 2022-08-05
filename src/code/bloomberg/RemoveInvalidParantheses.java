package code.bloomberg;

import java.util.*;

//https://leetcode.com/problems/remove-invalid-parentheses/solution/
//https://www.youtube.com/watch?v=Cbbf5qe5stw
//TC- O(2^n)
public class RemoveInvalidParantheses {

    public List<String> removeInvalidParentheses(String s) {

        List<String> res = new ArrayList<String>();
        if(s==null || s.length()==0){
            return res;
        }

        int minRemove = minRemove(s);

        helper(s,minRemove,res,new HashSet<String>());

        return res;
    }

    public void helper(String s,int minRemove,List<String> res,Set<String> set){
        if(minRemove==0){
            int minR = minRemove(s);
            if(minR==0 && !set.contains(s)){
                res.add(s);
                set.add(s);
            }
            return;
        }

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')' || s.charAt(i)=='('){
                String leftStr = s.substring(0,i);
                String rightStr = s.substring(i+1);
                String newStr = leftStr+rightStr;

                helper(newStr,minRemove-1,res,set);
            }
        }
    }
    public int minRemove(String s){
        Stack<Character> st = new Stack<Character>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(s.charAt(i));
            }
            else if(s.charAt(i)==')'){
                if(st.isEmpty()){
                    st.push(')');
                }
                else if(st.peek()=='('){
                    st.pop();
                }
                else{
                    st.push(')');
                }
            }
        }

        return st.size();
    }
}
