package code.leetcode.doordash;

/**
 * Time complexity : O(mn) Each vertex/cell will be calculated once and only once, and each edge will be visited once and only once. The total time complexity is then O(V+E)O(V+E). VV is the total number of vertices and EE is the total number of edges. In our problem, O(V) = O(mn)O(V)=O(mn), O(E) = O(4V) = O(mn)O(E)=O(4V)=O(mn).
 *
 * Space complexity : O(mn) The cache dominates the space complexity.
 */
public class LongestIncreasingPath {

        private static int dirs[][] = {{0,-1},{-1,0},{0,1},{1,0}};

        public static void main(String args[]){

            int matrix[][] = {{9,9,4},{6,6,8},{2,1,1}};
            System.out.println(longestIncreasingPath(matrix));
        }

    public static int longestIncreasingPath(int[][] matrix) {

        if(matrix==null || matrix.length==0){
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxLength = 0;

        int memo[][] = new int[rows][cols];

        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                memo[row][col] = 0;
            }
        }

        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                maxLength = Math.max(maxLength,dfs(matrix,row,col,rows,cols,memo));
            }
        }

        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                System.out.print(memo[row][col]+" ");
            }
            System.out.println();
        }

        return maxLength;
    }

    public static int dfs(int matrix[][],int row,int col,int rows,int cols,int memo[][]){

        if(memo[row][col]!=0){
            return memo[row][col];
        }

        for(int i=0;i<dirs.length;i++){
            int newRow = row+dirs[i][0];
            int newCol = col+dirs[i][1];

            if(newRow>=0 && newRow<rows && newCol>=0 && newCol<cols && matrix[newRow][newCol]>matrix[row][col]){
                memo[row][col] = Math.max(memo[row][col],dfs(matrix,newRow,newCol,rows,cols,memo));
            }
        }

        return ++memo[row][col];
    }

}
