package code.google;

//backtracking

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

    public static void main(String args[]){

        Set<String> dict = new HashSet<>();
        dict.add("hello");
        dict.add("hell");
        dict.add("on");
        dict.add("now");

        WordBreak obj = new WordBreak();

        System.out.println(obj.canBreakString("hellonow",dict,""));

    }

    public boolean canBreakString(String str,Set<String> dict,String temp){
        if(str.length()==0){
            System.out.println(temp);
            return true;
        }

        for(int i=1;i<=str.length();i++){
            String first = str.substring(0,i);
            if(dict.contains(first)){
                String second = str.substring(i);
                if(canBreakString(second,dict,temp+first+" ")){
                    return true;
                }
            }
        }

        return false;
    }

}
