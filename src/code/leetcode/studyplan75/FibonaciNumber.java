package code.leetcode.studyplan75;

public class FibonaciNumber {

    public int fib(int n) {

        if(n==0 || n==1){
            return n;
        }

        if(n==2){
            return 1;
        }

        int a = 1;
        int b = 1;
        int c = 0;

        for(int i=3;i<=n;i++){
            c = a+b;
            a = b;
            b = c;
        }

        return c;
    }
}
