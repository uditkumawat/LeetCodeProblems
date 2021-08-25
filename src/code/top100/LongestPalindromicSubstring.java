package code.top100;

//TC - O(n2)
//SC - O(1)
public class LongestPalindromicSubstring {

    private static int lowIndex = 0;
    private static int maxLen = 0;

    public static void main(String args[]){
        System.out.println(longestPalindrome("aba"));
        System.out.println(longestPalindrome("abcba"));
        System.out.println(longestPalindrome("abbdba"));
    }
        public static String longestPalindrome(String s) {

            if(s==null || s.length()<2) {
                return s;
            }
            lowIndex = 0;
            maxLen = 0;
            for(int i=0;i<s.length()-1;i++){
                expandAroundCenter(s,i,i); // odd length
                expandAroundCenter(s,i,i+1); // even length
            }

            System.out.println(lowIndex+" "+maxLen);
            return s.substring(lowIndex,lowIndex+maxLen);
        }

        public static void expandAroundCenter(String str,int low,int high) {
            while (low >= 0 && high < str.length()
              && str.charAt(low) == str.charAt(high)){
                low--;
                high++;
            }

            if (high-low-1 > maxLen) {
                lowIndex = low+1;
                maxLen = high-low-1;
            }
        }
}
