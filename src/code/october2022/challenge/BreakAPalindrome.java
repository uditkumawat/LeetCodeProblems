package code.october2022.challenge;

//https://www.youtube.com/watch?v=0DSALG_D8-I
//TC - O(N)
public class BreakAPalindrome {

    public String breakPalindrome(String palindrome) {

        if(palindrome==null || palindrome.length()<=1){
            return "";
        }

        char c[] = palindrome.toCharArray();


        for(int i=0;i<c.length/2;i++){
            if(c[i]!='a'){
                c[i] = 'a';
                return new String(c);
            }
        }

        c[c.length-1] = 'b';

        return new String(c);
    }
}
