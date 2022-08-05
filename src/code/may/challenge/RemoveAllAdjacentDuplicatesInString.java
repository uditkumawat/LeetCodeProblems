package code.may.challenge;

import java.util.Stack;

//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/submissions/
//TC - O(N)
//SC - O(1)
public class RemoveAllAdjacentDuplicatesInString {

    class ElemCount{
        char c;
        int count;
        ElemCount(char c,int count){
            this.c = c;
            this.count = count;
        }
    }

    public String removeDuplicates(String s, int k) {

        if(s==null || s.length()==0){
            return null;
        }

        Stack<ElemCount> stack = new Stack<>();

        for(char c:s.toCharArray()){

            if(!stack.isEmpty()){

                ElemCount ec = stack.peek();

                if(ec.c==c){

                    int newCount = ec.count+1;

                    stack.push(new ElemCount(c,newCount));

                    if(newCount>=k){

                        int removal = k;

                        while(removal>0){
                            stack.pop();
                            removal--;
                        }
                    }
                }
                else{
                    stack.push(new ElemCount(c,1));
                }
            }
            else{
                stack.push(new ElemCount(c,1));
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            ElemCount ec = stack.pop();
            sb.append(ec.c);
        }

        return sb.reverse().toString();
    }
}
