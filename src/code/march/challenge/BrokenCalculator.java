package code.march.challenge;

//https://leetcode.com/problems/broken-calculator/
//https://www.youtube.com/watch?v=u19WU2N4oYU

public class BrokenCalculator {

    public int brokenCalc(int startValue, int target) {

        int ans = 0;
        while(target>startValue){
            ans++;
            if(target%2==0){
                target = target/2;
            }
            else{
                target++;
            }
        }

        return ans + startValue-target;
    }
}
