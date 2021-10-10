package code.top100;

//TC - O(N*S)
public class SubsetSum {

    public static void main(String args[]){
        int arr[] = {1,2,3};
        int sum = 7;
        System.out.println(isSubsetSum(arr,sum));
    }

    /*
    if(sum==0 && n==0){
        return true;
    }
    else if(n==0 && sum!=0){
        return false;
    }
    else{
        return functionCall(arr,sum,n-1) || functionCall(arr,sum-arr[n-1],n-1)
    ]
     */
    public static boolean isSubsetSum(int arr[],int sum){

        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];

        dp[0][0] = true;

        //if none of the item is selected, then any sum value other than 0 will be false
        for(int i=1;i<=sum;i++){
            dp[0][i] = false;
        }

        //if sum is zero, then we can exclude that element, that will give us subset sum
        for(int i=1;i<=n;i++){
            dp[i][0] = true;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                    if(j-arr[i-1]>=0) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i-1]];
                    }
                    else{
                        dp[i][j] = dp[i-1][j];   //excluding curr element for sum
                    }
                }
        }


        return dp[n][sum];
    }
}
