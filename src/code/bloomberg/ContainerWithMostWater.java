package code.bloomberg;

//https://leetcode.com/problems/container-with-most-water/submissions/
//TC - O(N)
//SC - O(1)
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        if(height==null || height.length==0){
            return 0;
        }

        int max = 0;
        int len = height.length;
        int left = 0;
        int right = len-1;
        int area = 0;

        while(left<right){

            int leftHeight = height[left];
            int rightHeight = height[right];

            area = (right-left)*Math.min(leftHeight,rightHeight);

            max = Math.max(max,area);

            if(leftHeight<rightHeight){
                left++;
            }
            else{
                right--;
            }
        }

        return max;
    }
}
