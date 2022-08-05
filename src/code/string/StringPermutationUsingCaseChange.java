package code.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://www.youtube.com/watch?v=IYXWcjwhUYo
//TC - O(2^N)
public class StringPermutationUsingCaseChange {

    public static void main(String args[]) {

        String str = "a1b2";

        StringPermutationUsingCaseChange obj = new StringPermutationUsingCaseChange();
        List<String> res = new ArrayList<>();
        obj.getPermutations(str.toCharArray(),0,res);

        for(String s:res) {
            System.out.println(s);
        }
    }

    public void getPermutations(char str[],int endIndex,List<String> res){
        if(endIndex==str.length){
            res.add(String.valueOf(str));
            return;
        }


            if(Character.isLetter(str[endIndex])){

                //changing it to uppercase
                str[endIndex] = Character.toUpperCase(str[endIndex]);
                getPermutations(str,endIndex+1,res);


                //changing it to lowercase
                str[endIndex] = Character.toLowerCase(str[endIndex]);
                getPermutations(str,endIndex+1,res);

            }
            else{
                getPermutations(str,endIndex+1,res);
            }

    }

    public List<String> letterCasePermutations(String str){
        Queue<String> result = new LinkedList<>();
        result.add(str);
        int n = str.length();

        for(int i = n-1 ; i>=0 ; i--){
            char c = str.charAt(i);
            if(Character.isLetter(c)){
                int size = result.size();
                while(size-->0){
                    String s = result.poll();
                    String left = s.substring(0,i);
                    String right = s.substring(i+1);
                    result.add(left+Character.toUpperCase(c)+right);
                    result.add(left+Character.toLowerCase(c)+right);
                }
            }
        }

        return new ArrayList<>(result);
    }

}
