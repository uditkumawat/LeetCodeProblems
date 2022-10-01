package code.september2022.challenge;

//https://leetcode.com/problems/trapping-rain-water/submissions/
//TC - O(N)
//SC - O(1)
public class TrappingRainWater {

    public int trap(int[] height) {

        if(height==null || height.length==0){
            return 0;
        }

        int len = height.length;
        int left = 0;
        int right = len-1;
        int ans = 0;
        int maxLeft = 0;
        int maxRight = 0;

        while(left<=right){
            if(height[left]<height[right]){

                if(maxLeft<height[left]){
                    maxLeft = height[left];
                }
                else{
                    ans = ans + maxLeft-height[left];
                }

                left++;
            }
            else{
                if(maxRight<height[right]){
                    maxRight = height[right];
                }
                else{
                    ans = ans + maxRight-height[right];
                }
                right--;
            }

        }

        return ans;
    }
}
