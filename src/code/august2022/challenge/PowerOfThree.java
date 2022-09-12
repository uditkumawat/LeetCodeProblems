package code.august2022.challenge;

//https://leetcode.com/problems/power-of-three/
//TC - O(logn)/O(log3)
//SC - O(1)
public class PowerOfThree {

    public boolean isPowerOfThree(int n) {

        if(n<1){
            return false;
        }

        while(n % 3==0){
            n = n/3;
        }

        return n==1;
    }
}
