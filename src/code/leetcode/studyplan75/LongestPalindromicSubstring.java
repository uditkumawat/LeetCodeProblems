package code.leetcode.studyplan75;

//https://leetcode.com/problems/longest-palindromic-substring/submissions/
//TC - O(n^2)
//SC - O(1)
public class LongestPalindromicSubstring {

    int start = 0;
    int maxLen = 0;
    public String longestPalindrome(String s) {

        if(s==null || s.length()==0){
            return null;
        }

        for(int i=0;i<s.length();i++){

            //even length
            extendFromCenter(s,i,i);

            //odd length
            extendFromCenter(s,i,i+1);
        }

        return s.substring(start,start+maxLen);
    }

    public void extendFromCenter(String s,int left,int right){

        while(left>=0 && right<s.length()){
            if(s.charAt(left)!=s.charAt(right)){
                break;
            }
            left--;
            right++;
        }

        int len = right-left-1;
        if(maxLen<len){
            maxLen = len;
            start = left+1;
        }
    }
}
