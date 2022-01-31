package code.facebook;

public class StringToInteger {

    public static void main(String args[]){

        StringToInteger obj = new StringToInteger();
        System.out.println(obj.myAtoi("42"));
        System.out.println(obj.myAtoi("   -42"));
        System.out.println(obj.myAtoi("4193 with words"));
        System.out.println(obj.myAtoi("words and 987"));
        System.out.println(obj.myAtoi("-91283472332"));
    }
    public int myAtoi(String s) {

        if(s==null || s.length()==0){
            return 0;
        }

        int num = 0;
        int sign = 1;
        int left = 0;

        while(s.charAt(left)==' '){
            left++;
        }

        if(left<s.length()){

            char c = s.charAt(left);

            if(c=='-' || c=='+'){
                sign = c=='-'?-1:1;
                left++;
            }
        }

        for(;left<s.length();left++){
            char c = s.charAt(left);
            if(c>='0' && c<='9'){

                if(num>Integer.MAX_VALUE/10 || (num==Integer.MAX_VALUE/10
                && c-'0'>7)){
                    if(sign==1){
                        return Integer.MAX_VALUE;
                    }
                    else{
                        return Integer.MIN_VALUE;
                    }
                }
                num = num*10+ c-'0';
            }else{
                break;
            }
        }

        return num*sign;
    }
}
