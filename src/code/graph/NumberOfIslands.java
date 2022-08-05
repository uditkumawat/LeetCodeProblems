package code.graph;

//https://leetcode.com/problems/number-of-islands/
//TC - O(M*N)
public class NumberOfIslands {

    public static void main(String args[]){

        int grid[][] = {{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};

        NumberOfIslands obj = new NumberOfIslands();

        System.out.print(obj.numIslands(grid));
    }
    public int numIslands(int[][] grid) {

        if(grid==null || grid.length==0){
            return 0;
        }
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j,grid.length,grid[0].length);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(int grid[][],int row,int col,int rows,int cols){

        grid[row][col] = 0;

        int dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};

        for(int i=0;i<dirs.length;i++){

            int newRow = row+dirs[i][0];
            int newCol = col+dirs[i][1];

            if(isValid(grid,newRow,newCol,rows,cols)){
                dfs(grid,newRow,newCol,rows,cols);
            }
        }
    }

    public boolean isValid(int grid[][],int row,int col,int rows,int cols){
        if(row<0 || row>=rows || col<0 || col>=cols || grid[row][col]!=1){
            return false;
        }
        return true;
    }
}
