package code.leetcode.studyplan75;

public class InsertionSort {

    public int[] sortArray(int[] nums) {

        if(nums==null || nums.length==0){
            return nums;
        }

        for(int i=1;i<nums.length;i++){
            int j = i;
            while(j>0 && nums[j-1]>nums[j]){
                swap(nums,j-1,j);
                j--;
            }
        }

        return nums;
    }

    public void swap(int nums[],int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
