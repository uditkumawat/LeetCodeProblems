package code.top100;

public class SortColors {

    public static void main(String args[]){
        int arr[] = {0,0,2,2,1,0,0,0,1};
        sortColors(arr);
        for(int n:arr){
            System.out.print(n+" ");
        }
    }
    public static void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int index = 0;

        while(index<=end && start<end){
            if(nums[index]==0){
                nums[index] = nums[start];
                nums[start] = 0;
                index++;
                start++;
            }
            else if(nums[index]==2){
                nums[index] = nums[end];
                nums[end] = 2;
                end--;
                // not increamented index here becaue we dont know whic
                //swaps with end ..it can be 0 or 1...so need to move that also to
                //correct position.
            }
            else{
                index++;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
