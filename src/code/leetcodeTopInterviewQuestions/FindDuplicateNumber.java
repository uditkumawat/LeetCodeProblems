package code.leetcodeTopInterviewQuestions;

//https://leetcode.com/problems/find-the-duplicate-number/solution/
//TC - O(N)
//SC - O(1)
public class FindDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int duplicate = -1;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.abs(nums[i]);
            if (nums[cur] < 0) {
                duplicate = cur;
                break;
            }
            nums[cur] *= -1;
        }

        // Restore numbers
        for (int i = 0; i < nums.length; i++)
            nums[i] = Math.abs(nums[i]);

        return duplicate;
    }
}
