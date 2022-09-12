package code.bloomberg;

//https://leetcode.com/problems/next-permutation/submissions/
//https://www.youtube.com/watch?v=4IGGbhft4WM
public class NextPermutation {

    public void nextPermutation(int[] nums) {

        if(nums==null || nums.length==0 || nums.length==1){
            return;
        }

        int i = nums.length-2;

        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }

        if(i==-1){
            reverse(nums,0,nums.length-1);
            return;
        }

        int j = nums.length-1;

        while(j>=0 && nums[j]<=nums[i]){
            j--;
        }

        swap(nums,i,j);
        reverse(nums,i+1,nums.length-1);
    }

    public void reverse(int nums[],int start,int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public void swap(int nums[],int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
