package code.bloomberg;

//https://leetcode.com/problems/number-of-islands/submissions/
//TC - O(m*n)
//SC - O(1)
public class NumberOfIslands {

    int directions[][] = {{1,0},{0,1},{-1,0},{0,-1}};

    public int numIslands(char[][] grid) {

        if(grid==null || grid.length==0){
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;

        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(grid[row][col]=='1'){
                    count++;
                    dfs(grid,row,col,rows,cols);
                }
            }
        }

        return count;
    }

    public void dfs(char grid[][],int cRow,int cCol,int rows,int cols){

        if(!isValid(grid,cRow,cCol,rows,cols)){
            return;
        }

        grid[cRow][cCol] = '0';

        for(int i=0;i<directions.length;i++){

            int newRow = cRow + directions[i][0];
            int newCol = cCol + directions[i][1];

            dfs(grid,newRow,newCol,rows,cols);
        }
    }

    public boolean isValid(char grid[][],int cRow,int cCol,int rows,int cols){
        if(cRow<0 || cRow>=rows || cCol<0 || cCol>=cols || grid[cRow][cCol]=='0'){
            return false;
        }
        return true;
    }
}
