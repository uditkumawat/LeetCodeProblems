package code.leetcode.doordash;

/*

    Given an integer matrix, find the length of the longest path that have same values.
    The matrix has no boundary limits. (like, Google Maps - see edit for context)

    From each cell, you can either move to two directions: horizontal or vertical.
    You may NOT move diagonally or move outside of the boundary.

    nums = [
    [1,1],
    [5,5],
    [5,5]
    ]

    Return 4 ( Four 5's).
    */
//TC - O(M*N)
public class LongestLengthMatrix {


        public static void main(String[] args) {
            LongestLengthMatrix temp = new LongestLengthMatrix();
            int matrix[][] = {{1,1,2,1},{5,5,5,5},{5,5,5,1}};
            System.out.println(temp.findMax(matrix));
        }

        class Result {
            int count;
            int element;

            Result(int count,int element){
                this.count = count;
                this.element = element;
            }
        }
        public int findMax(int[][] arr) {
            int r = arr.length;
            int c = arr[0].length;

            int maxResult = Integer.MIN_VALUE;
            boolean[][] vis = new boolean[r][c];
            dp = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    Result result = new Result(1,arr[i][j]);
                    dfs(arr, i, j,r,c,arr[i][j], vis, result);
                    if (result.count>maxResult){
                        maxResult = result.count;
                    }
                }
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(dp[i][j]+" ");
                }
                System.out.println();
            }

            return maxResult;
        }

/*
x-1,y-1 x-1,y x-1,y+1
x,y-1 x,y x,y+1
x+1,y-1 x+1,y x+1,y+1
*/

        int[][] dp;
        private int[] dx = {0,-1,0,1};
        private int[] dy = {-1,0,1,0};

        private void dfs(int[][] arr, int i, int j,int r, int c, int val, boolean[][] vis, Result res) {
            if(dp[i][j]!=0) {
                res.count = dp[i][j];
                return;
            }

            vis[i][j] = true;

            for(int k=0;k<4;k++){
                int newi = i + dx[k];
                int newj = j + dy[k];
                if(isValid(arr,newi,newj,r,c,val,vis)){
                    res.count++;
                    dfs(arr,newi,newj,r,c,val,vis, res);
                }
            }

            dp[i][j] = res.count;
        }

        private boolean isValid(int[][] arr, int i, int j, int r, int c, int val, boolean[][] vis){
            if(i<0 || i>=r)
                return false;
            if(j<0 || j>=c)
                return false;
            if(arr[i][j]!=val)
                return false;
            if(vis[i][j])
                return false;
            return true;
        }

}
