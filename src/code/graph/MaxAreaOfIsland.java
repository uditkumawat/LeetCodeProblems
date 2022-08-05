package code.graph;

//https://leetcode.com/problems/max-area-of-island/
//TC - O(M*N)
//SC - O(M*N) recursion stack
public class MaxAreaOfIsland {

    public static void main(String args[]){

        int grid[][] = {{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};

        MaxAreaOfIsland obj = new MaxAreaOfIsland();

        System.out.print(obj.maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {

        if(grid==null || grid.length==0){
            return 0;
        }

        int maxArea = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    maxArea = Math.max(maxArea, dfs(grid,i,j,grid.length,grid[0].length));
                }
            }
        }

        return maxArea;
    }

    public int dfs(int grid[][],int row,int col,int rows,int cols){

        if(isValid(grid,row,col,rows,cols)){
            grid[row][col] = 0;
            return 1+dfs(grid,row-1,col,rows,cols)+dfs(grid,row,col+1,rows,cols)+
                    dfs(grid,row+1,col,rows,cols)+dfs(grid,row,col-1,rows,cols);
        }
        return 0;
    }

    public boolean isValid(int grid[][],int row,int col,int rows,int cols){
        if(row<0 || row>=rows || col<0 || col>=cols || grid[row][col]!=1){
            return false;
        }
        return true;
    }
}
