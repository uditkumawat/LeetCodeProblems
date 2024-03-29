package code.bloomberg;

import java.util.Arrays;

//https://leetcode.com/problems/dungeon-game/submissions/
//TC - O(M*N)
//SC - O(M*N)
public class DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {

        int m = dungeon.length;
        int n = dungeon[0].length;

        int dp[][] = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        dp[m-1][n] = 1;
        dp[m][n-1] = 1;
        dp[m][n] = 1;

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int minPower = Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j];
                dp[i][j] = minPower<=0?1:minPower;
            }
        }

        return dp[0][0];
    }
}
