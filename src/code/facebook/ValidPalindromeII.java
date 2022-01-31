package code.facebook;

//TC - O(N)
public class ValidPalindromeII {

    public static void main(String args[]){
        String s = "abc";
        ValidPalindromeII obj = new ValidPalindromeII();

        System.out.println(obj.validPalindrome(s));
    }
    public boolean validPalindrome(String s) {

        int i = 0;
        int j = s.length()-1;

        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return isPalindrome(s,i++,j) || isPalindrome(s,i,j--);
            }
            i++;
            j--;
        }

        return true;
    }

    public boolean isPalindrome(String s,int left,int right){
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
