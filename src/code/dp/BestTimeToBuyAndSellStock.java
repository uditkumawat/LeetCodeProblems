package code.dp;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//TC - O(N)
//SC - O(1)
public class BestTimeToBuyAndSellStock {

    public static void main(String args[]){

        int nums[] = {7,1,5,3,6,4};

        BestTimeToBuyAndSellStock obj = new BestTimeToBuyAndSellStock();

        System.out.println(obj.maxProfit(nums));

    }
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minValue = Integer.MAX_VALUE;

        for(int i=0;i<prices.length;i++){

            minValue = Math.min(minValue,prices[i]);

            maxProfit = Math.max(maxProfit,prices[i]-minValue);
        }

        return maxProfit;
    }
}
