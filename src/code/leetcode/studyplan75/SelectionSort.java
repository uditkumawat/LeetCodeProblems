package code.leetcode.studyplan75;

//TC - O(n^2)
//Sc - O(1)
public class SelectionSort {

    public int[] sortArray(int[] nums) {

        if(nums==null || nums.length==0){
            return nums;
        }

        int minIndex = 0;

        for(int i=0;i<nums.length;i++){

            minIndex = i;

            for(int j=i+1;j<nums.length;j++){
                if(nums[minIndex]>nums[j]){
                    minIndex = j;
                }
            }

            swap(nums,i,minIndex);
        }

        return nums;
    }

    public void swap(int nums[],int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
