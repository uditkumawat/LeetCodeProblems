package code.dp;

//https://leetcode.com/problems/delete-and-earn/
//https://www.youtube.com/watch?v=fevOTPYq2p8
//TC-O(N)
//SC-O(1)
public class DeleteAndEarn {

    public static void main(String args[]){

        int nums[] = {2,2,3,3,3,4};

        DeleteAndEarn obj = new DeleteAndEarn();

        System.out.print(obj.deleteAndEarn(nums));
    }
    public int deleteAndEarn(int[] nums) {

        int dp[] = new int[10001];
        int freq[] = new int[10001];

        for(int num:nums){
            freq[num]++;
        }

        dp[0] = 0;
        dp[1] = 1*freq[1];

        for(int i=2;i<10001;i++){

            dp[i] = Math.max(dp[i-1],dp[i-2]+i*freq[i]);
        }

        return dp[10000];

    }
}
