package code.leetcode.studyplan75;

//https://leetcode.com/problems/trapping-rain-water/
//Tc - O(N)
//SC - O(1)
public class TrappingRainWater {

    public int trap(int[] height) {

        int left = 0;
        int right = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;

        while(left<right){

            if(height[left]<height[right]){

                if(height[left]>leftMax){
                    leftMax = height[left];
                }
                else{
                    ans = ans+leftMax-height[left];
                }
                left++;
            }
            else{
                if(height[right]>rightMax){
                    rightMax = height[right];
                }
                else{
                    ans = ans+rightMax-height[right];
                }
                right--;
            }
        }

        return ans;
    }
}