package code.march.challenge;

//https://leetcode.com/problems/search-in-rotated-sorted-array/
//TC - O(logn)
//SC - O(1)
//https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
public class SearchInRotatedArray {

    public static void main(String args[]){

        int nums[] = {4,5,6,7,0,1,2};
        int target = 0;

        SearchInRotatedArray obj = new SearchInRotatedArray();

        System.out.println(obj.search(nums,target));

    }
    public int search(int[] nums, int target) {

        if(nums==null || nums.length==0){
            return 0;
        }

        int start = 0;
        int end = nums.length-1;

        while(start<=end){
            int mid = start+(end-start)/2;

            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>=nums[start]){
                //array is sorted from start to mid and target is present in between them
                if(target>=nums[start] && target<nums[mid]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            else{
                //array is sorted from mid to end and target is present in between them
                if(target<=nums[end] && target>nums[mid]){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}
