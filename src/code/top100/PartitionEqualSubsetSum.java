package code.top100;

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for(int n:nums){
            sum+=n;
        }

        if(sum%2==1){
            return false;
        }

        sum = sum/2;
        int n = nums.length;

        boolean dp[][] = new boolean[n+1][sum+1];

        dp[0][0] = true;

        for(int i=1;i<=sum;i++){
            dp[0][i] = false;
        }

        for(int i=1;i<=n;i++){
            dp[i][0] = true;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){

                if(nums[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    if(j-nums[i-1]>=0){
                        dp[i][j] = dp[i][j-nums[i-1]];
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }

        return dp[n][sum];
    }
}
