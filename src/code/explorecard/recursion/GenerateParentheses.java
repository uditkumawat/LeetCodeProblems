package code.explorecard.recursion;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/generate-parentheses/solution/
public class GenerateParentheses {

    public static void main(String args[]){

        GenerateParentheses obj = new GenerateParentheses();

        List<String> res = obj.generateParenthesis(4);

        for(String s:res){
            System.out.print(s+" ");
        }
    }
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();

        generateUtil(n,res,new StringBuilder(),0,0);
        return res;
    }

    public void generateUtil(int n,List<String> res,StringBuilder sb,int open,int close){
        if(close>open){
            return;
        }

        if(sb.length()==2*n){
            res.add(sb.toString());
            return;
        }

        if(open<n){
            sb.append("(");
            generateUtil(n,res,sb,open+1,close);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            sb.append(")");
            generateUtil(n,res,sb,open,close+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
