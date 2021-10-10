package code.leetcode.doordash;

//TC - O(rows*cols)
//Time: O(m*n), where m is number of rows, n is number of columns in the grid.
//Space: O(m*n), the space used by the call stack during our recursion, in worst case is O(m*n).
public class MaxAreaOfIsland {

    static int dirs[][]={{-1,0},{0,-1},{0,1},{1,0}};

    public static void main(String args[]){
        int matrix[][] = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};

        int mat[][] = {{0,0,0,0,0,0,0,0}};
        System.out.println(maxAreaOfIsland(matrix));

        System.out.println(maxAreaOfIsland(mat));
    }

    public static int maxAreaOfIsland(int[][] grid) {

        if(grid==null || grid.length==0){
            return 0;
        }
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(grid[row][col]==1){
                    maxArea = Math.max(maxArea,getMaxArea(grid,rows,cols,row,col));
                }
            }
        }

        return maxArea;
    }

    public static int getMaxArea(int grid[][],int rows,int cols,int row,int col){
        if(row<0 || col<0 || row>=rows || col>=cols || grid[row][col]==0){
            return 0;
        }

        grid[row][col] = 0;

        int area = 1;
        for(int i=0;i<dirs.length;i++){
            int newRow = row + dirs[i][0];
            int newCol = col + dirs[i][1];

            area+=getMaxArea(grid,rows,cols,newRow,newCol);
        }

        return area;
    }
}
