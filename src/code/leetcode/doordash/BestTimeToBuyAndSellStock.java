package code.leetcode.doordash;

public class BestTimeToBuyAndSellStock {

    public static void main(String args[]){
        int arr[]= {7,6,4,3,1};

        System.out.println(maxProfit(arr));
    }
    public static int maxProfit(int[] prices) {
        int minimumTillHere = Integer.MAX_VALUE;

        int maxProfit = 0;

        for(int i=0;i<prices.length;i++){

            minimumTillHere = Math.min(minimumTillHere,prices[i]);
            maxProfit = Math.max(maxProfit,prices[i]-minimumTillHere);
        }

        return maxProfit;
    }
}
