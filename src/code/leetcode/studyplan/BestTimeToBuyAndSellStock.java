package code.leetcode.studyplan;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/solution/
//TC - O(n)
//SC - O(1)
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {

        int max = 0;

        int min = prices[0];

        for(int i=1;i<prices.length;i++){
            max = Math.max(max,prices[i]-min);
            min = Math.min(min,prices[i]);
        }

        return max;
    }
}
