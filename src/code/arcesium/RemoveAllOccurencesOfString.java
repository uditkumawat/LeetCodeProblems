package code.arcesium;

import java.util.Stack;

//https://leetcode.com/problems/remove-all-occurrences-of-a-substring/
//
public class RemoveAllOccurencesOfString {

    public String removeOccurrences(String s, String part) {

        Stack<Character> stack = new Stack<>();
        int n = s.length();
        int m = part.length();

        for(int i=0;i<n;i++){

            stack.push(s.charAt(i));

            if(stack.size()>=m){

                StringBuilder sb = new StringBuilder();
                int j = m-1;
                for(;j>=0;j--){

                    if(part.charAt(j)==stack.peek()){
                        sb.append(part.charAt(j));
                        stack.pop();
                    }
                    else{
                        break;
                    }
                }

                if(j!=-1){
                    for(int k=sb.length()-1;k>=0;k--){
                        stack.push(sb.charAt(k));
                    }
                }
            }
        }

        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }
}
