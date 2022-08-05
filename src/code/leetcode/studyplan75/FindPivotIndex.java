package code.leetcode.studyplan75;

//https://leetcode.com/problems/find-pivot-index/solution/
//TC - O(N)
//SC - O(1)
public class FindPivotIndex {

    public int pivotIndex(int[] nums) {

        int sum = 0;

        for(int num:nums){
            sum += num;
        }

        int currSum = 0;

        for(int i=0;i<nums.length;i++){

            if(currSum == sum - currSum - nums[i]){
                return i;
            }

            currSum = currSum + nums[i];
        }

        return -1;
    }
}
