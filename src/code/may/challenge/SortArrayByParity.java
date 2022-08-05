package code.may.challenge;

//https://leetcode.com/problems/sort-array-by-parity/
//TC - O(N)
//SC - O(1)
public class SortArrayByParity {

    public static void main(String args[]){

        int nums[] = {3,1,2,4};

        SortArrayByParity obj = new SortArrayByParity();

        int res[] = obj.sortArrayByParity(nums);

        for(int num:nums){
            System.out.print(num+" ");
        }
    }
    public int[] sortArrayByParity(int[] nums) {

        if(nums==null || nums.length==0){
            return new int[0];
        }

        int left = 0;
        int right = nums.length-1;

        while(left<right){

            while(left<nums.length && nums[left]%2==0){
                left++;
            }

            while(right>=0 && nums[right]%2==1){
                right--;
            }

            if(left<right){
                swap(nums,left,right);
            }
            left++;
            right--;

        }

        return nums;
    }

    public void swap(int nums[],int i1,int i2){
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}
