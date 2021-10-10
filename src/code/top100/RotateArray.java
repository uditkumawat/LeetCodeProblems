package code.top100;

public class RotateArray {

    public static void main(String args[]){
        int nums[] = {1,2,3,4,5,6,7};
      //  int nums[] = {-1,-100,3,99};
        int k = 3;

        rotate(nums,k);

        for(int i:nums){
            System.out.print(i+" ");
        }
    }

    public static void rotate(int[] nums, int k) {

        int n = nums.length;

        if(k%n==0){
            return;
        }
        k = k%n;

        rotate(nums,0,k-1);
        rotate(nums,k,n-1);
        rotate(nums,0,n-1);

        return;

    }

    public static void rotate(int nums[],int left,int right){
        while(left<right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
