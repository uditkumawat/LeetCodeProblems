package code.explorecard.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationsOfPhoneNumber {


    public static void main(String args[]){

        String digits = "45";

        LetterCombinationsOfPhoneNumber obj = new LetterCombinationsOfPhoneNumber();

        List<String> res = obj.letterCombinations(digits);

        for(String str:res){
            System.out.println(str);
        }
    }

    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();

        Map<Integer,String> map = new HashMap();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        if(digits==null){
            return res;
        }


        buildUtil(digits,new StringBuilder(),res,0,map);


        return res;
    }

    public void buildUtil(String digits, StringBuilder sb, List<String> res, int digitIndex,Map<Integer,String> map){

        if(digitIndex==digits.length()){
            res.add(new String(sb));
            return;
        }

        String str = map.get(digits.charAt(digitIndex)-'0');

        for(int i=0;i<str.length();i++){
            sb.append(str.charAt(i));
            buildUtil(digits,sb,res,digitIndex+1,map);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
