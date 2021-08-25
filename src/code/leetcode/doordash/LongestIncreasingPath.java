package code.leetcode.doordash;

/**
 * Time complexity : O(mn)O(mn). Each vertex/cell will be calculated once and only once, and each edge will be visited once and only once. The total time complexity is then O(V+E)O(V+E). VV is the total number of vertices and EE is the total number of edges. In our problem, O(V) = O(mn)O(V)=O(mn), O(E) = O(4V) = O(mn)O(E)=O(4V)=O(mn).
 *
 * Space complexity : O(mn)O(mn). The cache dominates the space complexity.
 */
public class LongestIncreasingPath {

        private int dirs[][] = {{0,-1},{-1,0},{0,1},{1,0}};
        private int rows;
        private int cols;

        public int longestIncreasingPath(int[][] matrix) {

            if(matrix.length==0){
                return 0;
            }

            int ans=0;

            rows = matrix.length;
            cols = matrix[0].length;

            int cache[][] = new int[rows][cols];

            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    ans = Math.max(ans,dfs(matrix,i,j,cache));
                }
            }

            return ans;
        }

        public int dfs(int matrix[][],int currRow,int currCol,int cache[][]) {

            if (cache[currRow][currCol] != 0) {
                return cache[currRow][currCol];
            }

            for (int i = 0; i < dirs.length; i++) {
                int newRow = currRow + dirs[i][0];
                int newCol = currCol + dirs[i][1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && matrix[newRow][newCol] > matrix[currRow][currCol]) {
                    cache[currRow][currCol] = Math.max(cache[currRow][currCol], dfs(matrix, newRow, newCol, cache));
                }
            }

            return ++cache[currRow][currCol];
        }
}
