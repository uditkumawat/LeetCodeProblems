package code.leetcode.studyplan;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParanthesis {

    Map<Character,Character> map = new HashMap();


    public boolean isValid(String str) {

        Stack<Character> s = new Stack<>();

        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        for(char c:str.toCharArray()){

            if(isOpening(c)){
                s.push(c);
            }
            else{
                if(s.isEmpty() || !isMatching(c,s.peek())){
                    return false;
                }
                else{
                    s.pop();
                }
            }
        }

        return s.isEmpty();
    }

    public boolean isOpening(char c){
        return "({[".contains(c+"");
    }
    public boolean isMatching(char closed,char opened){

        if(map.get(closed)!=opened){
            return false;
        }
        return true;
    }
}
