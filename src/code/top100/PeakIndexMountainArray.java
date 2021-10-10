package code.top100;

public class PeakIndexMountainArray {

    public static void main(String args[]){

        int arr[] = {1,2,4,3,2,1};
        System.out.println(peakIndex(arr));
    }

    public static int peakIndex(int nums[]){
        int left = 0;
        int right = nums.length-1;

        while(left<right){
            int mid = left+(right-left)/2;

            if(nums[mid]<nums[mid+1]){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }

        return left;
    }
}
