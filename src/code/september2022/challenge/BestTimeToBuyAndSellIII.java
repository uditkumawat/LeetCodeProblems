package code.september2022.challenge;

public class BestTimeToBuyAndSellIII {

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
