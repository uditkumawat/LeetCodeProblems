package code.top100;

import java.util.Stack;

public class DecodedString {

    public static void main(String args[]){

        String s = "3[a2[b]]";

        System.out.println(decodeString(s));
    }
    public static String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int num=0;

        for(char c:s.toCharArray()){

            if(c>='0' && c<='9'){
                num = num*10+c-'0';
            }
            else if(c=='['){
                countStack.push(num);
                num = 0;
                stringStack.push(currentString);
                currentString = new StringBuilder();
            }else if(c==']'){
                StringBuilder decodedString = stringStack.pop();
                int count = countStack.pop();
                while(count-->0){
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            }
            else{
                currentString.append(c);
            }
        }

        return currentString.toString();
    }
}
