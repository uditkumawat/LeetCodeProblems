package code.explorecard.binarySearch;

/**
 * All the elements to the left of inflection point > first element of the array.
 * All the elements to the right of inflection point < first element of the array.
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {

        if(nums.length==1){
            return nums[0];
        }

        int left = 0;
        int right = nums.length-1;

        if(nums[0]<nums[right]){
            return nums[0];
        }

        while(left<=right){

            int mid = left+(right-left)/2;

            if(nums[mid]>nums[mid+1]){
                return mid+1;
            }
            if(nums[mid-1]>nums[mid]){
                return mid;
            }

            // if the mid elements value is greater than the 0th element this means
            // the least value is still somewhere to the right as we are still dealing with elements
            // greater than nums[0]
            if(nums[mid]>nums[0]){
                left = mid+1;
            }
            else{
                // if nums[0] is greater than the mid value then this means the smallest value is somewhere to
                // the left
                right = mid-1;
            }
        }

        return -1;
    }
}
