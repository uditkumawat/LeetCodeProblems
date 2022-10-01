package code.leetcodeTopInterviewQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/solution/
//TC - O(4^N * N) -> N is the length of digits , 4^N is because every digit has max 4 choices
//SC - O(N) - recursion stack
public class LetterCombinationsOfPhoneNumber {

    public static void main(String args[]){
        String digits = "79";
        System.out.println(letterCombinations(digits));
    }
    public static List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        if(digits==null || digits.length()==0){
            return res;
        }

        Map<Character,String> digitMap = new HashMap<>();
        digitMap.put('2',"abc");
        digitMap.put('3',"def");
        digitMap.put('4',"ghi");
        digitMap.put('5',"jkl");
        digitMap.put('6',"mno");
        digitMap.put('7',"pqrs");
        digitMap.put('8',"tuv");
        digitMap.put('9',"wxyz");

        backTrack(digits,digitMap,res,new StringBuilder(),0);

        return res;
    }

    public static void backTrack(String digits,Map<Character,String> digitMap,List<String> res,StringBuilder sb,int index){
        if(index>=digits.length()){
            res.add(sb.toString());
            return;
        }

        String str = digitMap.get(digits.charAt(index));
        for(char c:str.toCharArray()){
            sb.append(c);
            backTrack(digits,digitMap,res,sb,index+1);
            sb.setLength(sb.length()-1);
        }
    }
}
