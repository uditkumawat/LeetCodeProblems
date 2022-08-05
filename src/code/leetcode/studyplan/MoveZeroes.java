package code.leetcode.studyplan;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {

        int left = 0;
        int right = 0;

        while(right<nums.length){
            if(nums[right]!=0){
                nums[left++] = nums[right];
            }
            right++;
        }

        while(left<nums.length){
            nums[left++] = 0;
        }

    }
}
