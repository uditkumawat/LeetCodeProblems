package code.leetcode.studyplan75;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/happy-number/submissions/
//TC - O(N)
//SC - O(N)
public class HappyNumber {

    public boolean isHappy(int n) {

        Map<Integer,Integer> map = new HashMap();

        while(n!=1){

            int num = sumOfDigitSquares(n);
            if(map.containsKey(n)){
                return false;
            }
            map.put(n,num);
            n = num;
        }

        return true;
    }

    public int sumOfDigitSquares(int n){

        int sum = 0;
        while(n!=0){
            int digit = n%10;
            sum = sum + digit*digit;
            n = n/10;
        }

        return sum;
    }
}
