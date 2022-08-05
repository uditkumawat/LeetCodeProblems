package code.graph;

import java.util.LinkedList;
import java.util.Queue;

//https://www.youtube.com/watch?v=yV-b0amHNVM
//TC- O(m*n)
//https://leetcode.com/problems/as-far-from-land-as-possible/
public class AsFarFromLandAsPossible {

    public static void main(String args[]){

        int grid[][] = {{1,0,0},{0,0,0},{0,0,0}};

        AsFarFromLandAsPossible obj = new AsFarFromLandAsPossible();

        System.out.print(obj.maxDistance(grid));
    }
    public int maxDistance(int[][] grid) {

        if(grid==null || grid.length==0){
            return 0;
        }

        Queue<int[]> q = new LinkedList<>();

        int rows = grid.length;
        int cols = grid[0].length;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    q.add(new int[]{i,j});
                }
            }
        }

        int dist = -1;

        int directions[][] = {{-1,0},{0,1},{1,0},{0,-1}};

        while(!q.isEmpty()){
            int size = q.size();
            dist++;
            for(int i=0;i<size;i++){

                int cell[] = q.poll();


                for(int j=0;j<directions.length;j++){

                    int newRow = cell[0]+directions[j][0];
                    int newCol = cell[1]+directions[j][1];

                    if(isValid(grid,newRow,newCol,rows,cols)){
                        q.add(new int[]{newRow,newCol});
                        grid[newRow][newCol] = 1;
                    }
                }
            }
        }

        return dist;
    }

    public boolean isValid(int grid[][],int row,int col,int rows,int cols){
        if(row<0 || row>=rows || col<0 || col>=cols || grid[row][col]==1){
            return false;
        }
        return true;
    }
}
