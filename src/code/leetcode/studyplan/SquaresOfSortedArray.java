package code.leetcode.studyplan;

//https://leetcode.com/problems/squares-of-a-sorted-array/submissions/
public class SquaresOfSortedArray {

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;

        if(n==0){
            return new int[0];
        }

        int ans[] = new int[n];

        int left = 0;
        int right = n-1;
        int k = n-1;

        while(left<=right){
            int mul1 = nums[left]*nums[left];
            int mul2 = nums[right]*nums[right];

            if(mul2>mul1){
                ans[k--] = mul2;
                right--;
            }
            else{
                ans[k--] = mul1;
                left++;
            }
        }

        return ans;
    }
}
