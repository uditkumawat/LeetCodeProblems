package code.leetcodeTopInterviewQuestions;

//https://www.youtube.com/watch?v=CihX9yKR2xk
public class MinimumElementInSortedArray {

    public int findMin(int nums[]){

        int low = 0;
        int high = nums.length-1;
        while(low<high){
            int mid = low + (high-low)/2;
            if(nums[high]>=nums[mid]){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        return nums[low];
    }
}
