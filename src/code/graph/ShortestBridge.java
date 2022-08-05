package code.graph;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/shortest-bridge/
//https://www.youtube.com/watch?v=VuNzLtd8PBg
public class ShortestBridge {

    int dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};

    public int shortestBridge(int[][] grid) {

        if(grid==null){
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        boolean islandFound = false;
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){

                if(grid[i][j]==1){
                    dfs(grid,i,j,rows,cols,q);
                    islandFound = true;
                    break;
                }
            }

            if(islandFound){
                break;
            }
        }


        int steps = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){

                int cell[] = q.remove();
                int currRow = cell[0];
                int currCol = cell[1];

                for(int j=0;j<dirs.length;j++){

                    int newRow = currRow + dirs[j][0];
                    int newCol = currCol + dirs[j][1];


                    if(newRow>=0 && newRow<rows && newCol>=0 && newCol<cols && grid[newRow][newCol]!=-1)
                    {

                        if(grid[newRow][newCol]==1){
                            return steps;
                        }
                        q.add(new int[]{newRow,newCol});
                        grid[newRow][newCol] = -1;
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    public void dfs(int grid[][],int row,int col,int rows,int cols,Queue<int[]> q){

        grid[row][col] = -1;
        q.add(new int[]{row,col});

        for(int i=0;i<dirs.length;i++){

            int newRow = row + dirs[i][0];
            int newCol = col + dirs[i][1];

            if(isValidCell(grid,newRow,newCol,rows,cols)){
                dfs(grid,newRow,newCol,rows,cols,q);
            }
        }
    }

    public boolean isValidCell(int grid[][],int row,int col,int rows,int cols){

        if(row<0 || row>=rows || col<0 || col>=cols || grid[row][col]!=1){
            return false;
        }
        return true;
    }
}
