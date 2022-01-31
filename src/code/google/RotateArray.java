package code.google;

//TC - O(N)
//SC -O(1)
public class RotateArray {

    public static void main(String args[]){

        int nums[] = {1,2,3,4,5,6,7};

        RotateArray obj = new RotateArray();
        obj.rotate(nums,3);

        for(int num:nums){
            System.out.print(num+" ");
        }

    }
    public void rotate(int[] nums, int k) {

        int len = nums.length;
        k = k%len;

        if(k==0){
            return;
        }

        rotate(nums,0,len-1);
        rotate(nums,0,k-1);
        rotate(nums,k,len-1);
    }

    public void rotate(int nums[],int left,int right){
        if(left>right){
            return;
        }

        while(left<=right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
