package code.top100;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String args[]){
        int n=3;

        List<String> output = generateParentheses(n);

        for(String str:output){
            System.out.println(str);
        }
    }

    public static List<String> generateParentheses(int n){
        List<String> list = new ArrayList<>();
        backtrack(list,new StringBuilder(),0,0,n);
        return list;
    }

    public static void backtrack(List<String> list,StringBuilder str,int open,int close,int n){
        if(str.length()==2*n){
            list.add(new String(str.toString()));
            return;
        }

        if(open<n){
            str.append("{");
            backtrack(list,str,open+1,close,n);
            str.deleteCharAt(str.length()-1);
        }
        if(close<open){
            str.append("}");
            backtrack(list,str,open,close+1,n);
            str.deleteCharAt(str.length()-1);
        }
    }
}
