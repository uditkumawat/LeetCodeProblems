package code.amazon;

//https://leetcode.com/problems/reverse-integer/solution/
public class ReverseInteger {

    public static void main(String args[]){

        int num = -1230;

        ReverseInteger obj = new ReverseInteger();

        System.out.println(obj.reverse(num));
    }

    public int reverse(int num){

        long res = 0;
        boolean isNegative = false;

        if(num<0){
            isNegative = true;
            num = Math.abs(num);
        }

        while(num!=0){
            res = res*10 + num%10;
            num = num/10;
        }

        if(isNegative){
            res = -1*res;
        }

        if(res>Integer.MAX_VALUE || res<Integer.MIN_VALUE){
            return -1;
        }

        return (int)res;
    }
}
