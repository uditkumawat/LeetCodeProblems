package code.june.challenge;

//https://www.youtube.com/watch?v=ZScHTcerNlg
//https://leetcode.com/problems/remove-palindromic-subsequences/
//TC - O(N)
//SC - O(1)
public class RamovePalindromicSubsequences {

    public int removePalindromeSub(String s) {

        if(s==null || s.length()==0){
            return 0;
        }
        else if(isPalindrome(s)){
            return 1;
        }
        else{
            return 2;
        }
    }

    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
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
