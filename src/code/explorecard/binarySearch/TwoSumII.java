package code.explorecard.binarySearch;

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/solution/
//TC - O(n)
public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length-1;

        while(left<right){
            int sum = numbers[left]+numbers[right];
            if(sum==target){
                return new int[]{left+1,right+1};
            }
            else if(sum>target){
                left++;
            }
            else{
                right--;
            }
        }

        return new int[]{-1,-1};
    }
}
