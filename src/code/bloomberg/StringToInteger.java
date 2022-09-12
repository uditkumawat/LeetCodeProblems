package code.bloomberg;

//https://leetcode.com/problems/string-to-integer-atoi/solution/
//TC - O(N)
//SC - O(1)
public class StringToInteger {

    public int myAtoi(String s) {

        if(s==null || s.length()==0){
            return 0;
        }
        int len = s.length();
        int num = 0;
        int i = 0;
        long res = 0;

        while(i<len && s.charAt(i)==' '){
            i++;
        }

        int sign = 1;

        if(i<len){
            if(s.charAt(i)=='-'){
                sign = -1;
                i++;
            }
            else if(s.charAt(i)=='+'){
                sign = 1;
                i++;
            }
        }

        while(i<len && Character.isDigit(s.charAt(i))){

            int digit = s.charAt(i)-'0';
            res = res*10 + digit;
            i++;
            if(res>Integer.MAX_VALUE){
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
        }

        return sign*(int)res;
    }
}
