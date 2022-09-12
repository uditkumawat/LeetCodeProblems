package code.bloomberg;

import java.util.Stack;

//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/submissions/
//TC - O(N)
public class RemoveAllAdjacentDuplicatesInString {

    public String removeDuplicates(String s) {

        if(s==null || s.length()==0){
            return null;
        }

        Stack<Character> st = new Stack();

        for(char c:s.toCharArray()){
            if(st.isEmpty() || st.peek()!=c){
                st.push(c);
            }
            else{
                while(!st.isEmpty() && st.peek()==c){
                    st.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}
