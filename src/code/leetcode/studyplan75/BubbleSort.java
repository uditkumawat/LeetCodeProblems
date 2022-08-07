package code.leetcode.studyplan75;

//Tc - O(n^2)
//Sc - O(1)
public class BubbleSort {

    public int[] sortArray(int[] nums) {

        if(nums==null || nums.length==0){
            return nums;
        }

        boolean swapped = true;

        while(swapped){
            swapped = false;
            for(int i=0;i<nums.length-1;i++){
                if(nums[i]>nums[i+1]){
                    swap(nums,i,i+1);
                    swapped = true;
                }
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
