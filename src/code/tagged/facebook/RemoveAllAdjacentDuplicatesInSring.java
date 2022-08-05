package code.tagged.facebook;

import java.util.Stack;

//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
//TC-O(N)
//SC-O(N)
public class RemoveAllAdjacentDuplicatesInSring {

    public static void main(String args[]){

        RemoveAllAdjacentDuplicatesInSring obj = new RemoveAllAdjacentDuplicatesInSring();

        System.out.println(obj.removeDuplicates("abbaca"));

        System.out.println(obj.removeDuplicates("azxxzy"));

    }
    public String removeDuplicates(String s) {
        if(s==null || s.length()==0){
            return null;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++){
            int size = sb.length();
            char currChar = s.charAt(i);
            if(size>0 && sb.charAt(size-1)==currChar){
                sb.deleteCharAt(size-1);
            }
            else{
                sb.append(currChar);
            }
        }

        return sb.toString();
    }
}
