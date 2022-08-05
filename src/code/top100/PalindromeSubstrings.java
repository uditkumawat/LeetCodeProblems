package code.top100;

public class PalindromeSubstrings {

    public static void main(String args[]){

        String s = "abc";

        PalindromeSubstrings obj = new PalindromeSubstrings();

        System.out.println(obj.countSubstrings(s));

    }
    public int countSubstrings(String s) {

        int count = 0;

        for(int i=0;i<s.length();i++){

            count+=countPalindromeCenters(s,i,i);

            count+=countPalindromeCenters(s,i,i+1);
        }

        return count;
    }

    public int countPalindromeCenters(String s,int left,int right){

        int ans = 0;
        while(left>=0 && right<s.length()){
            if(s.charAt(left)!=s.charAt(right)){
                break;
            }
            left--;
            right++;
            ans++;
        }

        return ans;
    }
}
