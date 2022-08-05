package code.techdose;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//TC- O(len of string)
//SC - O(len of string)
public class ValidParantheses {

    public static void main(String args[]){

        String str = "[]{}";

        ValidParantheses obj = new ValidParantheses();

        System.out.println(obj.isValid(str));

    }
    public boolean isValid(String str){

        if(str==null || str.length()==0){
            return true;
        }

        Stack<Character> stack = new Stack<>();

        int i=0;

        while(i<str.length()){

            char c = str.charAt(i);

            if(isOpeningParantheses(c)){
                stack.push(c);
            }
            else if(isClosingParantheses(c)){
                if(stack.isEmpty()){
                    return false;
                }
                char topc = stack.pop();
                if(!isMatching(c,topc)){
                    return false;
                }
            }
            else{
                //any other character in string
                return false;
            }
            i++;
        }

        return stack.isEmpty();
    }
    private boolean isMatching(char c,char topc){

        Map<Character,Character> map = new HashMap<>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');

        return map.get(c)==topc;
    }
    private boolean isOpeningParantheses(char c){
       return (c=='{' || c=='[' || c=='(');
    }

    private boolean isClosingParantheses(char c){
        return (c=='}' || c==']' || c==')');
    }
}
