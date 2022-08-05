package code.google;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/solution/
public class LetterCombinations {

    public static void main(String args[]){

        String digits = "234";

        LetterCombinations obj = new LetterCombinations();

        List<String> res = obj.letterCombinations(digits);

        for(String s:res){
            System.out.println(s);
        }

    }
    public List<String> letterCombinations(String digits) {

        String dict[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        List<String> res = new ArrayList<>();

        util(digits,dict,res,0,new StringBuilder());

        return res;
    }

    public void util(String digits,String dict[],List<String> res,int index,StringBuilder sb){
        if(index>=digits.length()){
            res.add(sb.toString());
            return;
        }

        String str = dict[digits.charAt(index)-'0'];

        for(char c:str.toCharArray()){
            sb.append(c);
            util(digits,dict,res,index+1,sb);
            sb.setLength(sb.length()-1);
        }
    }
}
