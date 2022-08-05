package code.march.challenge;

import java.util.Stack;

//https://leetcode.com/problems/remove-duplicate-letters/
//TC - O(N)
//Sc - O(1)
//https://www.youtube.com/watch?v=muDlIlVE1q4
public class RemoveDuplicateLetters {

    public static void main(String args[]){

        String s = "cbacdcbc";

        RemoveDuplicateLetters obj = new RemoveDuplicateLetters();

        System.out.println(obj.removeDuplicateLetters(s));
    }

    public String removeDuplicateLetters(String s){

        if(s==null || s.length()==0){
            return s;
        }

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int lastIndex[] = new int[26];
        boolean visited[] = new boolean[26];

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            lastIndex[c-'a'] = i;
        }

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!visited[c-'a']){

                while(!stack.isEmpty() && c<stack.peek() && lastIndex[stack.peek()-'a']>i){
                    visited[stack.pop()-'a']=false;
                }

                visited[c-'a']=true;
                stack.push(c);
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
