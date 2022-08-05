package code.graph;

//https://leetcode.com/problems/number-of-enclaves/
//TC - O(m*n)
//SC - O(1)
public class NumberOfEnclaves {

    public static void main(String args[]){

        int grid[][] = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};

        NumberOfEnclaves obj = new NumberOfEnclaves();

        System.out.print(obj.numEnclaves(grid));
    }
    public int numEnclaves(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int resCount = 0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i==0 || i==rows-1 || j==0 || j==cols-1){
                    dfs(grid,i,j,rows,cols);
                }
            }
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    resCount++;
                }
            }
        }


        return resCount;
    }

    public void dfs(int grid[][],int row,int col,int rows,int cols){

        grid[row][col] = 0;

        if(isValid(grid,row,col,rows,cols)){
            dfs(grid,row-1,col,rows,cols);
            dfs(grid,row+1,col,rows,cols);
            dfs(grid,row,col-1,rows,cols);
            dfs(grid,row,col+1,rows,cols);
        }

    }

    public boolean isValid(int grid[][],int row,int col,int rows,int cols){
        if(row<0 || row>=rows || col<0 || col>=cols || grid[row][col]!=1){
            return false;
        }
        return true;
    }
}
