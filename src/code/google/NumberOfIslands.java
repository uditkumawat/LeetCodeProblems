package code.google;

//https://leetcode.com/problems/number-of-islands/solution/
public class NumberOfIslands {

    public static void main(String args[]) {

        int grid[][] = {{1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };

        NumberOfIslands obj = new NumberOfIslands();

        System.out.println(obj.countIslands(grid));

    }

    public int countIslands(int grid[][]){

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(grid[row][col]==1){
                    dfs(grid,row,col,rows,cols);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int grid[][],int row,int col,int rows,int cols){
        if(row<0 || row>=rows || col<0 || col>=cols || grid[row][col]==0){
            return;
        }

        grid[row][col] = 0;

        dfs(grid,row+1,col,rows,cols);
        dfs(grid,row,col+1,rows,cols);
        dfs(grid,row-1,col,rows,cols);
        dfs(grid,row,col-1,rows,cols);
    }
}
