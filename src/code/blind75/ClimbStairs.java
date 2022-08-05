package code.blind75;

//https://leetcode.com/problems/climbing-stairs/solution/
//TC - O(n)
//SC - O(1)
public class ClimbStairs {

    public int climbStairs(int n) {

        if(n==1 || n==2){
            return n;
        }
        int a = 1;
        int b = 2;
        int c = 0;
        for(int i=3;i<=n;i++){
            c = a+b;
            a = b;
            b = c;
        }

        return c;
    }
}
