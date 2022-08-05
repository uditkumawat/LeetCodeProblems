package code.booking.com;

//https://leetcode.com/problems/count-number-of-nice-subarrays/
//TC - O(N)
//SC - O(1)
//https://leetcode.com/problems/count-number-of-nice-subarrays/discuss/419378/JavaC%2B%2BPython-Sliding-Window-O(1)-Space
public class CountNumberOfNiceSubArrays {

    public static void main(String args[]){

        int nums[] = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;

        CountNumberOfNiceSubArrays obj = new CountNumberOfNiceSubArrays();
        System.out.println(obj.numberOfSubarrays(nums,k));

    }
    public int numberOfSubarrays(int[] nums, int k) {

        if(nums==null || nums.length==0){
            return 0;
        }

        int count = 0;
        int res = 0;
        int left = 0;
        int right = 0;

        while(right<nums.length){

            int num = nums[right];
            if(num%2==1){
                k--;
                count=0;
            }

            while(k==0){
                k+=nums[left++]&1;
                count++;
            }

            res = res + count;
            right++;
        }

        return res;
    }
}
