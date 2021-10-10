package code.top100;

//at many transactions
//peak valley approach
//Tc- O(N)
public class BestTimeToBuySellStockII {

    public static void main(String args[]){

        int arr[] = {7,1,5,3,6,4};
        int n = arr.length;
        int profit=0;
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1]){
                profit+=arr[i]-arr[i-1];
            }
        }
        System.out.println(profit);
    }
}
