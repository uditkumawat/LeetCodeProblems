package code.top100;

public class ReverseBits {

    public static void main(String args[]){

        int num = 31;

        System.out.println(reversed(num));

        System.out.println(numberOf1Bits(num));
    }

    public static int reversed(int num){

        if(num==0){
            return 0;
        }
        int res=0;

        for(int i=0;i<32;i++){
            res = res<<1;
            if((num&1)==1){
                res++;
            }
            num = num>>1;
        }

        return res;
    }

    public static int numberOf1Bits(int n) {
        int count=0;
        while(n!=0){
            if((n&1)==1){
                count++;
            }
            n=n>>>1;
        }
        return count;
    }
}
