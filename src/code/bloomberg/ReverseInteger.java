package code.bloomberg;

public class ReverseInteger {

    public static void main(String args[]){
        int num=123;

        System.out.println(reverse(num));
    }

    public static int reverse(int x) {

        long res = 0;

        while(x!=0){
            int remainder = x%10;
            res = res*10+remainder;
            if(res>Integer.MAX_VALUE || res <Integer.MIN_VALUE){
                return 0;
            }
            x=x/10;
        }

        return (int)res;
    }
}
