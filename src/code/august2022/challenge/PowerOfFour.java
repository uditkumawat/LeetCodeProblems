package code.august2022.challenge;

//https://leetcode.com/problems/power-of-four/submissions/
//TC - O(1)
//https://www.youtube.com/watch?v=krw01QNHcM0
public class PowerOfFour {

    public boolean isPowerOfFour(int n) {

        int count = 0;
        int index = 0;

        while(n!=0){
            if((n&1)==1){
                count++;
                if(index%2!=0){
                    return false;
                }
            }
            index++;
            n=n>>>1;
        }

        return count==1;
    }
}
