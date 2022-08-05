package code.july.challenge;

import java.util.Arrays;

//https://leetcode.com/problems/out-of-boundary-paths/solution/
//TC - O(mnN)
//SC - O(mnN)
public class OutOfBoundaryPaths {

    int M  = (int)Math.pow(10,9)+7;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

        int memo[][][] = new int[m][n][maxMove+1];

        for(int l[][]:memo){
            for(int s1[]:l){
                Arrays.fill(s1,-1);
            }
        }

        return findPaths(m,n,maxMove,startRow,startColumn,memo);
    }

    public int findPaths(int m,int n,int N,int i,int j,int memo[][][]){

        if(i==m || j==n || i<0 || j<0){
            return 1;
        }

        if(N==0){
            return 0;
        }

        if(memo[i][j][N]>=0){
            return memo[i][j][N];
        }

        memo[i][j][N] = (
                (findPaths(m, n, N - 1, i - 1, j, memo) + findPaths(m, n, N - 1, i + 1, j, memo)) % M +
                        (findPaths(m, n, N - 1, i, j - 1, memo) + findPaths(m, n, N - 1, i, j + 1, memo)) % M
        ) % M;

        return memo[i][j][N];
    }
}
