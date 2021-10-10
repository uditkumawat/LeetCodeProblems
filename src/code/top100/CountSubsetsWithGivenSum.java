package code.top100;

public class CountSubsetsWithGivenSum {

    public static void main(String args[]){

        int arr[] = {1,2,3};
        int sum = 5;

        System.out.println(countSubsets(arr,sum));
    }

    public static int countSubsets(int arr[],int sum){
        int n = arr.length;
        int dp[][] = new int[n+1][sum+1];

        dp[0][0] = 1;

        for(int i=1;i<=sum;i++){
            dp[0][i] = 0;
        }

        for(int i=1;i<=n;i++){
            dp[i][0] = 1;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    if(j-arr[i-1]>=0){
                        dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }

        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        return dp[n][sum];
    }

}
