package code.blind75;

//TC - O(n^2)
//SC - O(1)
public class LongestPalindromicSubstring {

    int maxLength = 0;
    int left = 0;
    int right = 0;

    public String longestPalindrome(String s) {

        if(s==null || s.length()==0){
            return null;
        }

        for(int i=0;i<s.length();i++){
            expandAroundCenter(s,i,i);
            expandAroundCenter(s,i,i+1);
        }

        return s.substring(left,right+1);

    }

    public void expandAroundCenter(String s,int lower,int upper){

        while(lower>=0 && upper<s.length()){
            if(s.charAt(lower)!=s.charAt(upper)){
                break;
            }
            lower--;
            upper++;
        }

        int currStringLength = upper-lower-1;
        if(currStringLength>maxLength){
            maxLength = currStringLength;
            left = lower+1;
            right = upper-1;
        }
    }
}
