package code.salesforce;

//https://leetcode.com/problems/longest-mountain-in-array/submissions/
//TC - O(N)
//SC - O(1)
public class LongestMountainInArray {

    public int longestMountain(int[] arr) {

        int right = 0;
        int left = 0;
        int max = 0;

        for(int i=1;i<arr.length-1;i++){

            if(arr[i-1]<arr[i] && arr[i]>arr[i+1]){
                right = i;
                left = i;
                while(left>0 && arr[left-1]<arr[left]){
                    left--;
                }
                while(right<arr.length-1 && arr[right+1]<arr[right]){
                    right++;
                }

                max = Math.max(max,right-left+1);
            }

        }

        return max;
    }
}
