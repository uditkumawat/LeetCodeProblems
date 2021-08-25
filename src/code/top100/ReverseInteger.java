package code.top100;

public class ReverseInteger {

    public static void main(String args[]){
        int num=120;

        System.out.println(reverse(num));
    }

    public static int reverse(int x) {

        int res = 0;
        while(x>0){
            int remainder = x%10;

            int tempResult = res*10+remainder;

            //check for overflow
            if((tempResult-remainder)/10!=res){
                return 0;
            }

            res = tempResult;
            x=x/10;
        }
        return res;
    }
}
