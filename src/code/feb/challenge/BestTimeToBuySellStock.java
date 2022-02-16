package code.feb.challenge;

public class BestTimeToBuySellStock {

    public static void main(String args[]){

        int arr[] = {7, 1, 5, 3, 6, 4};

        BestTimeToBuySellStock obj = new BestTimeToBuySellStock();

        System.out.println(obj.maxProfit(arr));
    }
    public int maxProfit(int[] prices) {

        if(prices==null || prices.length<=1){
            return 0;
        }

        int profit = 0;
        int minPrice = Integer.MAX_VALUE;

        for(int i=0;i<prices.length;i++){
            if(prices[i]<minPrice){
                minPrice = prices[i];
            }
            else{
                profit = Math.max(profit,prices[i]-minPrice);
            }
        }

        return profit;
    }
}
