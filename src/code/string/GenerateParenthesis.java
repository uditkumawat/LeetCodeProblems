package code.string;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=s9fokUqJ76A
public class GenerateParenthesis {

    public static void main(String args[]){

        int n = 3;

        GenerateParenthesis obj = new GenerateParenthesis();

        List<String> res = obj.generate(n);

        for(String str:res){
            System.out.println(str);
        }
    }

    public List<String> generate(int n){

        List<String> res = new ArrayList<>();

        backtrack(n,0,0,new StringBuilder(),res);

        return res;
    }

    private void backtrack(int n,int open,int close,StringBuilder sb,List<String> res){
        if(open==close && close==n){
            res.add(sb.toString());
            return;
        }

        if(open<n){
            sb.append("(");
            backtrack(n,open+1,close,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close<n && close<open){
            sb.append(")");
            backtrack(n,open,close+1,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
