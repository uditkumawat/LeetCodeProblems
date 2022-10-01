package code.october2022.challenge;

//https://leetcode.com/problems/increasing-triplet-subsequence/
//https://www.youtube.com/watch?v=9ACruzu6lXM
//TC - O(N)
//SC - O(1)
//https://leetcode.com/problems/increasing-triplet-subsequence/solutions/79000/my-accepted-java-solution-for-this-question-only-7-lines-clear-and-concise/
public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {

        if(nums==null || nums.length==0){
            return false;
        }

        int left = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;

        for(int el:nums){
            if(el>mid){
                return true;
            }
            else if(el<mid && el>left){
                mid = el;
            }
            else if(el<left){
                left = el;
            }
        }
        return false;
    }

}
