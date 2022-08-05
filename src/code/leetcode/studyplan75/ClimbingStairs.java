package code.leetcode.studyplan75;

//https://leetcode.com/problems/climbing-stairs/submissions/
//TC - O(N)
//SC -O(1)
public class ClimbingStairs {

    public int climbStairs(int n) {
        if(n==0){
            return 0;
        }

        if(n==1 || n==2){
            return n;
        }

        int first = 1;
        int second = 2;
        int third = 0;
        for(int i=3;i<=n;i++){
            third = first+second;
            first = second;
            second = third;
        }

        return third;
    }
}
