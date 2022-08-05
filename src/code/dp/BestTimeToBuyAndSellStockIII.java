package code.dp;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/solution/

/**
 * Time Complexity: \mathcal{O}(N)O(N) where NN is the length of the input sequence, since we have two iterations of length NN.
 *
 * Space Complexity: \mathcal{O}(N)O(N) for the two arrays that we keep in the algorithm.
 */
public class BestTimeToBuyAndSellStockIII {

    public int maxProfit(int[] prices) {

        if(prices==null || prices.length<2){
            return 0;
        }

        int n = prices.length;

        int leftMin = prices[0];
        int rightMax = prices[n-1];

        int leftProfits[] = new int[n];
        int rightProfits[] = new int[n+1];

        for(int i=1;i<n;i++){
            leftProfits[i] = Math.max(leftProfits[i-1],prices[i]-leftMin);
            leftMin = Math.min(leftMin,prices[i]);
        }

        for(int i=n-1;i>=0;i--){
            rightProfits[i] = Math.max(rightProfits[i+1],rightMax-prices[i]);
            rightMax = Math.max(rightMax,prices[i]);
        }

        int maxProfit = 0;

        for(int i=0;i<n;i++){
            maxProfit = Math.max(maxProfit,leftProfits[i]+rightProfits[i+1]);
        }

        return maxProfit;

    }
}
