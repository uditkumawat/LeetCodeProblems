package code.bloomberg;

//TC - O(R*C)
//SC - O(1)
public class MaxAreaOfIsland {

    int directions[][] = {{1,0},{0,1},{-1,0},{0,-1}};
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
        int area = 1;

        for(int i=0;i<directions.length;i++){

            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];

            area = area + dfs(grid,newRow,newCol,rows,cols);
        }

        return area;
    }
}
