package code.bloomberg;

public class JumpGameII {

    public int jump(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        Integer dp[] = new Integer[nums.length];
        dp[nums.length-1] = 0;

        for(int i=dp.length-2;i>=0;i--){

            int steps = nums[i];
            int min = Integer.MAX_VALUE;

            for(int j=1;j<=steps && i+j<dp.length;j++){

                if(dp[i+j]!=null && dp[i+j]<min){
                    min = dp[i+j];
                }
            }
            if(min!=Integer.MAX_VALUE){
                dp[i] = min+1;
            }
        }

        return dp[0];
    }
}
