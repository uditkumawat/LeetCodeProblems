package code.bloomberg;

//https://www.youtube.com/watch?v=tmakGVOGV3A&list=PLtQWXpf5JNGLKwqnEtL54puLD7aRTkYyD&index=12
//TC - O(N)
//SC -O(N)
public class MaximumSubArray {

    public int maxSubArray(int nums[]){

        int max = nums[0];

        for(int i=1;i<nums.length;i++){
            nums[i] = Math.max(nums[i],nums[i]+nums[i-1]);
            max = Math.max(max,nums[i]);
        }

        return max;
    }
}
