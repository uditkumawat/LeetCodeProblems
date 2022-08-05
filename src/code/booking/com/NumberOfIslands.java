package code.booking.com;

//https://leetcode.com/problems/number-of-islands/
//TC - O(MN)
//SC - O(1)
public class NumberOfIslands {

    public static void main(String args[]){

        int grid[][] = {
                          {1,1,0,0,0},
                          {1,1,0,0,0},
                          {0,0,1,0,0},
                          {0,0,0,1,1}
                    };

        NumberOfIslands obj = new NumberOfIslands();

        System.out.println(obj.numIslands(grid));

        
    }
    public int numIslands(int[][] grid) {

        if(grid==null || grid.length==0){
            return 0;
        }

        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j,rows,cols);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(int grid[][],int row,int col,int rows,int cols){
        if(!isValid(grid,row,col,rows,cols)){
            return;
        }

        grid[row][col] = 0;

        dfs(grid,row+1,col,rows,cols);

        dfs(grid,row,col+1,rows,cols);

        dfs(grid,row-1,col,rows,cols);

        dfs(grid,row,col-1,rows,cols);
    }

    private boolean isValid(int grid[][],int row,int col,int rows,int cols){
        if(row<0 || row>=rows || col<0 || col>=cols || grid[row][col]==0){
            return false;
        }
        return true;
    }
}
