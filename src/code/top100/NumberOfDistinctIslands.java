package code.top100;

import java.util.HashSet;
import java.util.Set;

//https://www.youtube.com/watch?v=c1ZxUOHlulo
public class NumberOfDistinctIslands {

    public static void main(String args[]){

        int grid[][] = {{1,1,1,1},{1,1,0,0,},{0,0,0,1},{1,1,1,1}};

        System.out.println(distinctIslands(grid));
    }

    public static int distinctIslands(int grid[][]){

        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Set<String> islands = new HashSet<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    String island = getIsland(grid,i,j,rows,cols,"X");
                    islands.add(island);
                }
            }
        }

        return islands.size();
    }

    public static String getIsland(int grid[][],int i,int j,int rows,int cols,String direction){

        if(i<0 || i>=rows || j<0 || j>=cols){
            return "O";
        }

        if(grid[i][j]==0){
            return "O";
        }

        grid[i][j] = 0;

        String up = getIsland(grid,i-1,j,rows,cols,"U");
        String down = getIsland(grid,i+1,j,rows,cols,"D");
        String left = getIsland(grid,i,j-1,rows,cols,"L");
        String right = getIsland(grid,i,j+1,rows,cols,"R");

        return direction+up+down+left+right;
    }
}
