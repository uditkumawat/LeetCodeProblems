package code.dp;

//https://leetcode.com/problems/longest-palindromic-substring/solution/
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        if(s==null || s.length()==0){
            return null;
        }

        return getLongestPalindrome(s);
    }

    public String getLongestPalindrome(String s){

        int start = 0;
        int end = 0;
        for(int i=0;i<s.length();i++){

            int len1 = expandAroundCenter(s,i-1,i+1);
            int len2 = expandAroundCenter(s,i,i+1);

            int len = Math.max(len1,len2);
            if(len>end-start){
                start = i - (len-1)/2;
                end = i + len/2;
            }

        }

        return s.substring(start,end+1);
    }

    public int expandAroundCenter(String s,int left,int right){

        while(left>=0 && right<s.length()){
            if(s.charAt(left)!=s.charAt(right)){
                break;
            }
            left--;
            right++;
        }

        return right-left-1;
    }
}
