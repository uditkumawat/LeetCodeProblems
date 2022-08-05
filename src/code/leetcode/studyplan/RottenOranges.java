package code.leetcode.studyplan;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/rotting-oranges/submissions/
//TC - O(N)
//SC - O(N)
public class RottenOranges {

    public int orangesRotting(int[][] grid) {

        if(grid==null || grid.length==0){
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int numberOfFreshOranges = 0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    numberOfFreshOranges++;
                }
            }
        }

        if(numberOfFreshOranges==0){
            return 0;
        }

        int mins = -1;

        int directions[][] = {{-1,0},{1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){

                int cell[] = q.remove();

                for(int j=0;j<directions.length;j++){
                    int newRow = cell[0]+directions[j][0];
                    int newCol = cell[1]+directions[j][1];

                    if(isValid(grid,newRow,newCol,rows,cols)){
                        if(grid[newRow][newCol]==1){
                            grid[newRow][newCol] = 2;
                            numberOfFreshOranges--;
                            q.add(new int[]{newRow,newCol});
                        }
                    }
                }
            }
            mins++;
        }

        return numberOfFreshOranges==0?mins:-1;
    }

    public boolean isValid(int grid[][],int row,int col,int rows,int cols){
        if(row<0 || row>=rows || col<0 || col>=cols){
            return false;
        }
        return true;
    }
}
