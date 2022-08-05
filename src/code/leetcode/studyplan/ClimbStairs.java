package code.leetcode.studyplan;

public class ClimbStairs {

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
