package code.booking.com;

//https://leetcode.com/problems/coloring-a-border/
//https://www.youtube.com/watch?v=R3AJoOBVAlg
public class ColoringABorder {

    public static void main(String args[]){

        int grid[][] = {{1,1,1},{1,1,1},{1,1,1}};
        int row = 1;
        int col = 1;
        int color = 2;

        ColoringABorder obj = new ColoringABorder();
        grid = obj.colorBorder(grid,row,col,color);

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
    public int directions[][] = {{-1,0},{0,1},{1,0},{0,-1}};

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {

        if(grid==null || grid.length==0){
            return grid;
        }

        dfs(grid,row,col,grid[row][col]);

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]<0){
                    grid[i][j] = color;
                }
            }
        }

        return grid;
    }

    public void dfs(int grid[][],int row,int col,int oldColor){
        grid[row][col] = -oldColor;

        int count = 0;

        for(int i=0;i<directions.length;i++){

            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];

            if(newRow<0 || newRow>=grid.length || newCol<0 || newCol>=grid[0].length
                    || Math.abs(grid[newRow][newCol])!=oldColor){
                continue;
            }

            count++;

            if(grid[newRow][newCol]==oldColor){
                dfs(grid,newRow,newCol,oldColor);
            }
        }

        if(count==4){
            grid[row][col] = oldColor;
        }

    }
}
