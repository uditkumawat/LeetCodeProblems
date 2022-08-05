package code.leetcode.studyplan;

//https://leetcode.com/problems/sort-colors/submissions/
//TC - O(N)
//SC - O(1)
public class SortColors {

    public void sortColors(int[] nums) {

        if(nums==null || nums.length==0){
            return;
        }

        int left = 0;
        int mid = 0;
        int right = nums.length-1;

        while(mid<=right){
            if(nums[mid]==0){
                swap(nums,left,mid);
                left++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else if(nums[mid]==2){
                swap(nums,mid,right);
                right--;
            }
        }
    }

    public void swap(int nums[],int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
