package code.top100;

//https://www.youtube.com/watch?v=37s1_xBiqH0&list=PLEJXowNB4kPxbFzYz06LrPQpsMxYeKxiB&index=9
//TC- O(N)
//SC - O(N)
public class BestTimeToBuyAndSellAtMaxTwoStocks {

    public static void main(String args[]){
        int arr[] = {2,3,4,1,3,2,4};
        System.out.println(getMaxProfitFromTwoStocks(arr));
    }

    public static int getMaxProfitFromTwoStocks(int arr[]){

        if(arr==null || arr.length==0){
            return 0;
        }
        int n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];

        int leftMin = arr[0];
        int rMax = arr[n-1];

        for(int i=1;i<n;i++){
            left[i] = Math.max(left[i-1],arr[i]-leftMin);
            leftMin = Math.min(leftMin,arr[i]);
        }

        for(int i=n-2;i>=0;i--){
            right[i] = Math.max(right[i+1],rMax-arr[i]);
            rMax = Math.max(rMax,arr[i]);
        }

        int maxProfit = Integer.MIN_VALUE;

        for(int i=1;i<n;i++){
            maxProfit = Math.max(maxProfit,left[i-1]+right[i]);
        }

        return maxProfit;
    }
}
