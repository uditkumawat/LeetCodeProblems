package code.top100;

//https://www.youtube.com/watch?v=CMaZ69P1bAc&list=PLEJXowNB4kPxQIN2dCUAnQ_92HIziG4x6&index=11
public class CatalanNumber {

    //c(n) = c(0)c(n-0+1) + c(1)c(n-1+1) + c(2)c(n-2+1) .......c(n)C(n-n+1)

    public static int findCatalan(int n) {
        int dp[] = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = 0;

            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j+1];
            }
        }

        return dp[n];
    }
}
