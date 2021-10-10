package code.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity : O(N*2^N)
 * N
 *  ), where NN is the length of string ss. This is the worst-case time complexity when all the possible substrings are palindrome.
 */
public class PalindromePartitioning {


    public static void main(String args[]){
        String s = "abba";
        List<List<String>> list = partition(s);
        for(List<String> l:list){
            System.out.println(l);
        }
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(0,result,new ArrayList<String>(),s);
        return result;
    }

    public static void dfs(int start,List<List<String>> result,List<String> currentList,String s){
        if(start>=s.length()){
            result.add(new ArrayList<>(currentList));
        }

        for(int end=start;end<s.length();end++){
            if(isPalindrome(s,start,end)){
                currentList.add(s.substring(start,end+1));
                dfs(end+1,result,currentList,s);
                currentList.remove(currentList.size()-1);
            }
        }
    }

    static boolean isPalindrome(String s,int low,int high){
        while(low<high){
            if(s.charAt(low)!=s.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
