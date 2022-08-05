package code.explorecard.binarySearch;

public class SearchInRotatedSortedArray {

    public static void main(String args[]){

        int nums[] = {4,5,6,7,0,1,2};
        int target = 4;

        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();

        System.out.println(obj.search(nums,target));
    }
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[left]<=nums[mid]){
                if(nums[left]<=target && target<=nums[mid]){
                    right = mid - 1;
                }
                else{
                    left = mid+1;
                }
            }
            else{
                if(nums[mid]<=target && target<=nums[right]){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
        }

        return -1;
    }
}
