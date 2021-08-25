package code.top100;

public class SortColors {

    public static void main(String args[]){
        int arr[] = {0};
        sortColors(arr);
        for(int n:arr){
            System.out.print(n+" ");
        }
    }
    public static void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int left = 0, right = nums.length - 1;// Left, right boundary
        for (int i = 0; i <= right; i++) {
            if (nums[i] == 0 && i != left)// Only swap if i != left
                swap(nums, i--, left++);
            else if (nums[i] == 2 && i != right)// Only swap if i != right
                swap(nums, i--, right--);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
