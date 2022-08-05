package code.march.challenge;

//https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/
//TC - O(N)
//SC - O(1)
//https://www.youtube.com/watch?v=vmY9ctncXQI
public class MaximumLengthOfSubarraywithPositiveProduct {

    public static void main(String args[]){

        int nums[] = {0,1,-2,-3,-4};

        MaximumLengthOfSubarraywithPositiveProduct obj = new MaximumLengthOfSubarraywithPositiveProduct();

        System.out.println(obj.getMaxLen(nums));

    }
    public int getMaxLen(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        int start = 0;
        int end = 0;

        int countNegative = 0;
        int firstNegativeElementIndex = -1;
        int lastNegativeElementIndex = -1;
        int len = nums.length;
        int maxLen = 0;

        for(int i=0;i<nums.length;){

            while(start<len && nums[start]==0){
                start++;
            }

            end = start;

            countNegative = 0;

            while(end<len && nums[end]!=0){

                if(nums[end]<0){

                    countNegative++;

                    if(firstNegativeElementIndex==-1){
                        firstNegativeElementIndex = end;
                    }
                    else{
                        lastNegativeElementIndex = end;
                    }
                }

                end++;
            }

            if(countNegative%2==0){
                maxLen = Math.max(maxLen,end-1-start+1);
            }
            else{
                if(firstNegativeElementIndex!=-1){
                    maxLen = Math.max(maxLen,end-1-firstNegativeElementIndex+1);
                }
                else if(lastNegativeElementIndex!=-1){
                    maxLen = Math.max(maxLen,lastNegativeElementIndex-1-start+1);
                }
            }
            i = end+1;
        }

        return maxLen;
    }
}
