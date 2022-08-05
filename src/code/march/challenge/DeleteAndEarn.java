package code.march.challenge;

//https://www.youtube.com/watch?v=fevOTPYq2p8
//https://leetcode.com/problems/delete-and-earn/
public class DeleteAndEarn {

    public static void main(String args[]){

        int nums[] = {5,5,5,6,6,6,6,7,7};

        DeleteAndEarn obj = new DeleteAndEarn();

        System.out.println(obj.deleteAndEarn(nums));
    }

    public int deleteAndEarn(int nums[]){

        int freq[] = new int[10002];
        int dp[] = new int[10002];

        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }

        dp[0] = 0;
        dp[1] = 1*freq[1];

        for(int i=2;i<10002;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+i*freq[i]);
        }

        return dp[10001];
    }
}
