package code.top100;

//https://www.youtube.com/watch?v=FlX5A5YNRp0&list=PLDdcY4olLQk3Z2Gyo3-VN8gvi7DRKK-YY&index=7
//TC - O(n^2)
public class MinimumNumberOfJumpsToReachEnd {

    public static void main(String args[]){

        int arr[] = {1,4,3,2,6,7};

        System.out.println(minJumps(arr));
    }

    public static int minJumps(int arr[]){

        if(arr==null || arr.length==0){
            return 0;
        }

        int n = arr.length;

        int dp[] = new int[n];
        for(int i=0;i<n;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){

                if(dp[j]!=Integer.MAX_VALUE && (arr[j]+j>=i)){
                    if(dp[i]>dp[j]+1){
                        dp[i] = dp[j]+1;
                    }
                }
            }
        }

        return dp[n-1]!=Integer.MAX_VALUE?dp[n-1]:-1;
    }
}
