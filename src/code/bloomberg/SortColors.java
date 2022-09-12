package code.bloomberg;

//https://www.youtube.com/watch?v=HuS-ZsnEdbc
//TC - O(N)
public class SortColors {

    public void sortColors(int[] nums) {

        int left = 0;
        int right = nums.length-1;
        int curr = 0;

        while(curr<right){
            if(nums[curr]==0){
                swap(nums,left,curr);
                left++;
                curr++;
            }
            else if(nums[curr]==2){
                swap(nums,right,curr);
                right--;
            }
            else{
                curr++;
            }
        }
    }

    public void swap(int nums[],int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
