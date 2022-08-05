package code.bloomberg;

import java.util.Stack;

//https://leetcode.com/problems/decode-string/submissions/
//https://www.youtube.com/watch?v=6GFxWHvPMps
//TC - O(M*N)
//SC - O(M+N) -> M number of digitis, N number of chars
//https://www.youtube.com/watch?v=SF2W6VDs7bc&t=2s
public class DecodeString {

    public String decodeString(String s) {

        if(s==null || s.length()==0){
            return null;
        }

        int num = 0;
        StringBuilder sb = new StringBuilder();

        Stack<Integer> numberStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        for(int i=0;i<s.length();i++){

            if(isNumber(s.charAt(i))){
                num = num*10 + s.charAt(i)-'0';
            }
            else if(s.charAt(i)=='['){
                numberStack.push(num);
                stringStack.push(sb);
                num = 0;
                sb = new StringBuilder();
            }
            else if(s.charAt(i)==']'){
                int lastNumber = numberStack.pop();
                StringBuilder temp = sb;
                sb = stringStack.pop();
                while(lastNumber-->0){
                    sb.append(temp);
                }
            }
            else{
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }


    private boolean isNumber(char c){
        return c>='0' && c<='9';
    }
}
