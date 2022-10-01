package code.leetcodeTopInterviewQuestions;

//https://leetcode.com/problems/majority-element/solution/
//TC - O(N)
//SC - O(1)
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
