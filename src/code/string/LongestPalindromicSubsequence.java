package code.string;

public class LongestPalindromicSubsequence {

    public static void main(String args[]){

        String str = "abdbca";

        LongestPalindromicSubsequence obj = new LongestPalindromicSubsequence();

        System.out.println(obj.getLPS(str,0,str.length()-1));
    }

    //TC - O(2^n)
    //SC - O(n) - recursive stack
    public int getLPS(String str,int startIndex,int endIndex){
        if(startIndex>endIndex){
            return 0;
        }

        //when only single element in string , so it will palindrome
        if(startIndex==endIndex){
            return 1;
        }

        // case 1: elements at the beginning and the end are the same
        if(str.charAt(startIndex)==str.charAt(endIndex)){
            return 2 + getLPS(str,startIndex+1,endIndex-1);
        }

        // case 2: skip one element either from the beginning or the end
        int c1 = getLPS(str,startIndex+1,endIndex);
        int c2 = getLPS(str,startIndex,endIndex-1);

        return Math.max(c1,c2);
    }

    public boolean isPalindrome(String str,int left,int right){
        while(left<right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public int findLPSLength(String st) {
        Integer[][] dp = new Integer[st.length()][st.length()];
        return findLPSLengthRecursive(dp, st, 0, st.length()-1);
    }

    private int findLPSLengthRecursive(Integer[][] dp, String st, int startIndex, int endIndex) {
        if(startIndex > endIndex)
            return 0;

        // every sequence with one element is a palindrome of length 1
        if(startIndex == endIndex)
            return 1;

        if(dp[startIndex][endIndex] == null) {
            // case 1: elements at the beginning and the end are the same
            if(st.charAt(startIndex) == st.charAt(endIndex)) {
                dp[startIndex][endIndex] = 2 + findLPSLengthRecursive(dp, st, startIndex+1, endIndex-1);
            } else {
                // case 2: skip one element either from the beginning or the end
                int c1 =  findLPSLengthRecursive(dp, st, startIndex+1, endIndex);
                int c2 =  findLPSLengthRecursive(dp, st, startIndex, endIndex-1);
                dp[startIndex][endIndex] = Math.max(c1, c2);
            }
        }

        return dp[startIndex][endIndex];
    }
}
