package code.top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Time complexity: O(4^N \cdot N)O(4
 * N
 *  ⋅N), where NN is the length of digits. Note that 44 in this expression is referring to the maximum value length in the hash map, and not to the length of the input.
 *
 * The worst-case is where the input consists of only 7s and 9s. In that case, we have to explore 4 additional paths for every extra digit. Then, for each combination, it costs up to NN to build the combination. This problem can be generalized to a scenario where numbers correspond with up to MM digits, in which case the time complexity would be O(M^N \cdot N)O(M
 * N
 *  ⋅N). For the problem constraints, we're given, M = 4M=4, because of digits 7 and 9 having 4 letters each.
 *
 * Space complexity: O(N)O(N), where NN is the length of digits.
 *
 * Not counting space used for the output, the extra space we use relative to input size is the space occupied by the recursion call stack. It will only go as deep as the number of digits in the input since whenever we reach that depth, we backtrack.
 *
 * As the hash map does not grow as the inputs grows, it occupies O(1)O(1) space.
 */
public class LetterCombinations {

    public static void main(String args[]){
        String digits = "32";
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
