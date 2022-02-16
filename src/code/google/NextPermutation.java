package code.google;

import java.util.Arrays;

/**
 * We swap the numbers a[i-1]a[i−1] and a[j]a[j]. We now have the correct number at index i-1i−1. But still the current permutation isn't the permutation that we are looking for. We need the smallest permutation that can be formed by using the numbers only to the right of a[i-1]a[i−1]. Therefore, we need to place those numbers in ascending order to get their smallest permutation.
 *
 * But, recall that while scanning the numbers from the right, we simply kept decrementing the index until we found the pair a[i]a[i] and a[i-1]a[i−1] where, a[i] > a[i-1]a[i]>a[i−1]. Thus, all numbers to the right of a[i-1]a[i−1] were already sorted in descending order. Furthermore, swapping a[i-1]a[i−1] and a[j]a[j] didn't change that order. Therefore, we simply need to reverse the numbers following a[i-1]a[i−1] to get the next smallest lexicographic permutation.
 */
public class NextPermutation {

    public static void main(String args[]){

        int arr[] = {1,1,5};

        NextPermutation obj = new NextPermutation();

        int res[] = obj.nextPermutation(arr);

        for(int num:res){
            System.out.print(num);
        }
    }

    public int[] nextPermutation(int[] nums) {
        if(nums==null || nums.length==0){
            return null;
        }

        int i=0;

        for(i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                break;
            }
        }

        if(i==0){
            Arrays.sort(nums);
            return nums;
        }

        i--;

        int j = nums.length-1;

        while(nums[j]<nums[i]){
            j--;
        }

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        reverse(nums,i+1,nums.length-1);

        return nums;
    }

    public void reverse(int nums[],int left,int right){
        while(left<=right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
