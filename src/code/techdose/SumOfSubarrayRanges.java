package code.techdose;

public class SumOfSubarrayRanges {

    public static void main(String args[]){

        int nums[] = {1,2,3};

        SumOfSubarrayRanges obj = new SumOfSubarrayRanges();
        System.out.println(obj.subArrayRanges(nums));
    }
    public long subArrayRanges(int[] nums) {

        long res = 0;
        for(int i=0;i<nums.length;i++){
            int min = nums[i];
            int max = nums[i];
            for(int j=i;j<nums.length;j++){
                max = Math.max(max,nums[j]);
                min = Math.min(min,nums[j]);
                res+=max-min;
            }
        }

        return res;
    }
}
