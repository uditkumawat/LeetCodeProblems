package code.leetcode.studyplan;

//https://leetcode.com/problems/max-area-of-island/solution/
//TC - O(R*C)
//SC - O(R*C)
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    int area = dfs(grid,i,j,rows,cols);
                    maxArea = Math.max(maxArea,area);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int grid[][],int row,int col,int rows,int cols){

        if(row<0 || row>=rows || col<0 || col>=cols || grid[row][col]!=1){
            return 0;
        }

        grid[row][col]=0;

        return 1+dfs(grid,row-1,col,rows,cols)+dfs(grid,row+1,col,rows,cols)+
                dfs(grid,row,col-1,rows,cols)+dfs(grid,row,col+1,rows,cols);
    }
}
