package code.bloomberg;

import java.util.Random;

//https://leetcode.com/problems/random-pick-with-weight/submissions/
//TC - O(logn)
//SC - O(N)
public class RandomPickWithWeight {

    int max;
    int sum[];
    Random rand;
    public RandomPickWithWeight(int[] w) {
        sum = new int[w.length];
        sum[0] = w[0];
        rand = new Random();
        for(int i=1;i<w.length;i++){
            sum[i] = sum[i-1]+w[i];
        }
        max = sum[sum.length-1];
    }

    public int pickIndex() {

        int low = 0;
        int high = sum.length-1;
        int target = 1+rand.nextInt(max);
        while(low<=high){
            int mid = low+(high-low)/2;
            if(sum[mid]==target){
                return mid;
            }
            else if(sum[mid]>target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return low;
    }
}
