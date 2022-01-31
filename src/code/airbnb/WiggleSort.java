package code.airbnb;

public class WiggleSort {

    public static void main(String args[]){

        int nums[] = {6,6,5,6,3,8};
        WiggleSort obj = new WiggleSort();
        obj.getWiggleSortedArray(nums);
        for(int num:nums){
            System.out.print(num+" ");
        }
    }

    public void getWiggleSortedArray(int nums[]){
        for(int i=1;i<nums.length;i+=2) {

            if (i > 0 && nums[i] < nums[i - 1]) {
                swap(nums, i, i - 1);
            }
            if (i < nums.length - 1 && nums[i] < nums[i + 1]) {
                swap(nums, i, i + 1);
            }
        }
    }

    private void swap(int nums[],int t1,int t2){
        int temp = nums[t1];
        nums[t1] = nums[t2];
        nums[t2] = temp;
    }
}
