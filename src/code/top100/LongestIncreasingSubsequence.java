package code.top100;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String args[]){
        int arr[]={7,7,7,7,7,7,7};
        System.out.println(lengthOfLIS(arr));
    }
    public static int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }

        int arr[] = new int[nums.length];

        Arrays.fill(arr,1);

        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && arr[i]<arr[j]+1){
                    arr[i] = arr[j]+1;
                }
            }
        }

        int maxLength = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            maxLength = Math.max(maxLength,arr[i]);
        }

        return maxLength;
    }
}
