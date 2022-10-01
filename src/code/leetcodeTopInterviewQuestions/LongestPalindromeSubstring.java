package code.leetcodeTopInterviewQuestions;

//https://leetcode.com/problems/longest-palindromic-substring/solution/
//TC - O(n^2)
//SC - O(1)
public class LongestPalindromeSubstring {

    class Solution {

        int maxLen = 0;
        int startingPoint = 0;

        public String longestPalindrome(String s) {

            if(s==null || s.length()==0){
                return null;
            }

            for(int i=0;i<s.length();i++){

                //even length palindrome
                checkForPalindrome(s,i,i+1);

                //odd length palindrome
                checkForPalindrome(s,i,i);

            }

            return s.substring(startingPoint,maxLen+startingPoint);
        }

        public void checkForPalindrome(String s,int left,int right){

            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }

            int len = right-left-1;

            if(maxLen<len){
                maxLen = len;
                startingPoint = left+1;
            }
        }
    }
}
