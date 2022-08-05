package code.bloomberg;

//https://leetcode.com/problems/knight-dialer/submissions/
//https://leetcode.com/problems/knight-dialer/discuss/190787/How-to-solve-this-problem-explained-for-noobs!!!
public class KnightDailer {

    public int MOD = 1000000007;

    public int knightDialer(int n) {

        long dp[][][] = new long[n+1][4][3];
        long sum = 0;

        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                sum = (sum + paths(dp,i,j,n)) % MOD;
            }
        }

        return (int)sum;
    }


    public long paths(long dp[][][],int row,int col,int n){

        if(row<0 || row>=4 || col<0 || col>=3 || (row == 3 && col != 1)){
            return 0;
        }

        if(n==1){
            return 1;
        }

        if(dp[n][row][col]>0){
            return dp[n][row][col];
        }

        dp[n][row][col] = paths(dp,row-2,col+1,n-1) % MOD
                + paths(dp,row-1,col+2,n-1) % MOD
                + paths(dp,row+1,col+2,n-1) % MOD
                + paths(dp,row+2,col+1,n-1) % MOD
                + paths(dp,row+2,col-1,n-1) % MOD
                + paths(dp,row+1,col-2,n-1) % MOD
                + paths(dp,row-1,col-2,n-1) % MOD
                + paths(dp,row-2,col-1,n-1) % MOD;


        return dp[n][row][col];
    }
}
