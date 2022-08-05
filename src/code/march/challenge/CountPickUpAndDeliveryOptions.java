package code.march.challenge;

//https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/
//https://www.youtube.com/watch?v=p1tvA-eQFqk
public class CountPickUpAndDeliveryOptions {

    public static void main(String args[]){

        int n = 3;

        CountPickUpAndDeliveryOptions obj = new CountPickUpAndDeliveryOptions();

        System.out.println(obj.count(n));

    }

    public int count(int n){

        long dp[] = new long[501];
        long mod = (long)Math.pow(10,9)+7;

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 6;

        for(int i=3;i<=n;i++){
            int maxPosition = 2*i-1;
            int totalPermutations = maxPosition*(maxPosition+1)/2;

            dp[i] = (dp[i-1]*totalPermutations)%mod;
        }

        return (int)dp[n];
    }
}
