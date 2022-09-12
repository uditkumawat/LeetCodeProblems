package code.salesforce;

//TC - O(N)
//SC - O(1)
public class SortColors {

    public void sortColors(int[] nums) {

        int zero = 0;
        int two = nums.length-1;
        int curr = 0;

        while(curr<=two){
            if(nums[curr]==0){
                swap(nums,zero,curr);
                zero++;
                curr++;
            }
            else if(nums[curr]==1){
                curr++;
            }
            else if(nums[curr]==2){
                swap(nums,curr,two);
                two--;
            }
        }
    }

    public void swap(int nums[],int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
