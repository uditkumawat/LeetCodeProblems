package code.explorecard.binarySearch;

//https://www.youtube.com/watch?v=r7U0N2EE_l8&t=32s
public class FindPeakElement {

    public int findPeakElement(int[] nums) {

        int low = 0;
        int high = nums.length-1;

        while(low<high){
            int mid = low+(high-low)/2;
            if(nums[mid]<nums[mid+1]){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }

        return low;
    }
}
