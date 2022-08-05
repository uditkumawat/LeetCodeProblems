package code.booking.com;

//https://www.youtube.com/watch?v=dF5vBO4bbzs
//TC - O(N)
//SC - O(1)
public class LengthOfLongestContinuousIncreasingSubSequence {


    public static void main(String args[]){

        int arr[] = {1,3,5,4,7};

        LengthOfLongestContinuousIncreasingSubSequence obj = new LengthOfLongestContinuousIncreasingSubSequence();

        System.out.println(obj.findLengthOfLCIS(arr));
    }

    public int findLengthOfLCIS(int nums[]){

        if(nums==null || nums.length==0){
            return 0;
        }
        int max = 1;
        int curr = 1;

        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                curr++;
                max = Math.max(max,curr);
            }
            else{
                curr = 1;
            }
        }

        return max;
    }
}
