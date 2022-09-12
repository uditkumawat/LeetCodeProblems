package code.dp;

public class TribonacciNumber {

    public static void main(String args[]){

        int n = 25;

        TribonacciNumber obj = new TribonacciNumber();

        System.out.print(obj.tribonacci(n));
    }

    public int tribonacci(int n) {

        int a = 0;
        int b = 1;
        int c = 1;
        if(n==0){
            return a;
        }

        if(n==1 || n==2){
            return n;
        }

        int val = 0;
        for(int i=3;i<=n;i++){
            val = a + b + c;
            a = b;
            b = c;
            c = val;
        }

        return val;
    }

    /*
    int map[] = new int[38];
    public int tribonacci(int n) {

        if(n==0){
            return 0;
        }

        if(n==1 || n==2){
            return 1;
        }

        if(map[n]==0){
            map[n] = tribonacci(n-3) + tribonacci(n-2) + tribonacci(n-1);
        }

        return map[n];
    }
     */
}
