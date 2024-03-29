package code.april.challenge;

//https://leetcode.com/problems/valid-palindrome-ii/solution/
//TC - O(N)
//SC - O(1)
public class ValidPalindromeII {

    public static void main(String args[]){

        ValidPalindromeII obj = new ValidPalindromeII();

        System.out.println(obj.isValidPalindrome("aba"));
        System.out.println(obj.isValidPalindrome("abca"));
        System.out.println(obj.isValidPalindrome("abc"));

    }
    public boolean isValidPalindrome(String s){

        int left = 0;
        int right = s.length()-1;

        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)){
                return isValid(s,left+1,right) || isValid(s,left,right-1);
            }
            left++;
            right--;
        }

        return true;
    }

    private boolean isValid(String s,int left,int right){
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
