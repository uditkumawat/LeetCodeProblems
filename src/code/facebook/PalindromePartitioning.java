package code.facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity : \mathcal{O}(N \cdot 2^{N})O(N⋅2
 * N
 *  ), where NN is the length of string ss. This is the worst-case time complexity when all the possible substrings are palindrome.
 */
public class PalindromePartitioning {

    public static void main(String args[]){

        String s = "abba";

        PalindromePartitioning obj = new PalindromePartitioning();
        List<List<String>> res = obj.partition(s);

        for(List<String> list:res){
            System.out.println(list);
        }
    }
    public List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<>();

        partitionUtil(s,res,new ArrayList<String>(),0);

        return res;
    }

    public void partitionUtil(String s,List<List<String>> res,List<String> temp,int start){

        if(start>=s.length()){

            if(!temp.isEmpty()){
                res.add(new ArrayList<String>(temp));
            }
            return;
        }

        for(int end=start;end<s.length();end++){

            if(isValidPalindrome(s,start,end)){

                temp.add(s.substring(start,end+1));

                partitionUtil(s,res,temp,end+1);

                temp.remove(temp.size()-1);
            }
        }
    }

    public boolean isValidPalindrome(String s,int left,int right){

        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
