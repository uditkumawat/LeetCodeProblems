package code.march.challenge;

//https://leetcode.com/problems/binary-search
//TC - O(logn)
//SC - O(1)
public class BinarySearch {

    public static void main(String args[]){

        int nums[] = {-1,0,3,5,9,12};
        int target = 2;

        BinarySearch obj = new BinarySearch();

        System.out.println(obj.search(nums,target));
    }
    public int search(int[] nums, int target) {

        if(nums==null || nums.length==0){
            return -1;
        }

        return binarySearch(nums,target,0,nums.length-1);
    }

    public int binarySearch(int nums[],int target,int left,int right){

        if(left>right){
            return -1;
        }

        int mid = left+(right-left)/2;

        if(nums[mid]==target){
            return mid;
        }
        else if(nums[mid]>target){
            return binarySearch(nums,target,left,mid-1);
        }
        else{
            return binarySearch(nums,target,mid+1,right);
        }
    }

    public int binarySearch(int nums[],int target){
        int left = 0;
        int right = nums.length-1;

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
