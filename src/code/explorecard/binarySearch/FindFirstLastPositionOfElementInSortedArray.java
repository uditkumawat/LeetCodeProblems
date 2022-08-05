package code.explorecard.binarySearch;

//https://www.youtube.com/watch?v=Y7LiLNdayF0
//TC - O(logn)
//SC- O(1)
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FindFirstLastPositionOfElementInSortedArray {

    public static void main(String args[]){

        int nums[] = {5,7,7,8,8,10};
        int target = 10;

        FindFirstLastPositionOfElementInSortedArray obj = new FindFirstLastPositionOfElementInSortedArray();
        int ans[] = obj.searchRange(nums,target);

        System.out.println(ans[0]+" "+ans[1]);
    }
    public int[] searchRange(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;

        int ans[] = {-1,-1};

        //first occurence

        while(left<=right){

            int mid = left+(right-left)/2;

            if(nums[mid]==target){
                ans[0] = mid;
                right = mid-1;
            }
            else if(nums[mid]<target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }

        left = 0;
        right = nums.length-1;

        //last occurence

        while(left<=right){

            int mid = left+(right-left)/2;

            if(nums[mid]==target){
                ans[1] = mid;
                left = mid+1;
            }
            else if(nums[mid]<target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }

        return ans;
    }
}
