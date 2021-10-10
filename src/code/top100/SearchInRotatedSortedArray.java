package code.top100;

public class SearchInRotatedSortedArray {

    public static void main(String args[]){
        int arr[] = {6,7,0,1,2,3,4,5};
        int target = 0;

        System.out.println(search(arr,target));
    }
    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;

        while(left<right){
            int midpoint = left+(right-left)/2;
            if(nums[midpoint]>nums[right]){
                left = midpoint+1;
            }
            else{
                right = midpoint;
            }
        }

        int start=left;
        left = 0;
        right = nums.length-1;

        if(target>=nums[start] && target<=nums[right]){
            left =start;
        }
        else{
            right = start;
        }

        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return -1;
    }
}
