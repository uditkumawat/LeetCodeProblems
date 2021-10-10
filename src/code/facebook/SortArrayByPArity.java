package code.facebook;

/**
 * Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
 *
 * Return any array that satisfies this condition.
 */
class SortArrayByParity {

    public static void main(String args[]){

        SortArrayByParity obj = new SortArrayByParity();

        int nums[] = {3,1,2,4};

        int output[] = obj.sortArrayByParity(nums);

        for(int num:output){
            System.out.print(num+" ");
        }
    }

    public int[] sortArrayByParity(int[] nums) {

        if(nums==null || nums.length==0){
            return nums;
        }

        int leftPointer = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                swap(nums,leftPointer,i);
                leftPointer++;
            }
        }

        return nums;
    }

    public void swap(int nums[],int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
