package code.leetcodeTopInterviewQuestions;

//https://leetcode.com/problems/container-with-most-water/solution
//TC - O(n)
//SC - O(1)
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxarea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int width = right - left;
            maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * width);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxarea;
    }
}
