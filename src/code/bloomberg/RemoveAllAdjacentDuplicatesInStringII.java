package code.bloomberg;

import java.util.Stack;

//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/submissions/
//TC - O(N)
//SC - O(N)
public class RemoveAllAdjacentDuplicatesInStringII {

    class Entry{
        char c;
        int count;
        Entry(char c){
            this.c = c;
            this.count = 1;
        }
    }

    public String removeDuplicates(String s, int k) {

        Stack<Entry> stack = new Stack<>();

        for(char c:s.toCharArray()){

            if(!stack.isEmpty()){

                Entry peekEntry = stack.peek();

                if(peekEntry.c == c){
                    peekEntry.count++;
                    if(peekEntry.count==k){
                        stack.pop();
                    }
                }
                else{
                    stack.push(new Entry(c));
                }
            }
            else{
                stack.push(new Entry(c));
            }
        }

        // System.out.println(stack.size());
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            Entry entry = stack.pop();
            while(entry.count!=0){
                sb.append(entry.c);
                entry.count--;
            }
        }

        return sb.reverse().toString();
    }
}
