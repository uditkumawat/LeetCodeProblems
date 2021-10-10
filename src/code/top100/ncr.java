package code.top100;

public class ncr {

    public static void main(String args[]){

        int n = 5;
        int r = 3;

        System.out.println(calculate(n,r));
    }

    public static int calculate(int n,int r){
        if(n<r){
            return 0;
        }
        if(n-r<r){
            r = n-r;
        }

        int dp[] = new int[r+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=Math.min(i,r);j>0;j--){
                dp[j] = dp[j]+dp[j-1];
            }
        }
        return dp[r];
    }
}
