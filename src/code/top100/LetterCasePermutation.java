package code.top100;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/letter-case-permutation/discuss/255071/Java-detailed-explanation-of-DFSBacktracking-solution
public class LetterCasePermutation {

    public static void main(String args[]){

        String str = "a1b1";

        List<String> list = new ArrayList<>();

        getPermutations(str.toCharArray(),0,list);

        for(String s:list){
            System.out.println(s);
        }
    }

    public static void getPermutations(char str[],int index,List<String> list){
        if(index==str.length){
            list.add(new String(str));
            return;
        }
        else{
            if(Character.isLetter(str[index])){
                str[index] = Character.toLowerCase(str[index]);
                getPermutations(str,index+1,list);
                str[index] = Character.toUpperCase(str[index]);
                getPermutations(str,index+1,list);
            }
            else{
                getPermutations(str,index+1,list);
            }
        }
    }
}
