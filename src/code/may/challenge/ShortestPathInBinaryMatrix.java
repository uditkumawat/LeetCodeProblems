package code.may.challenge;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    public static void main(String args[]){

        int grid[][] = {{1,0,0},{1,1,0},{1,1,0}};

        ShortestPathInBinaryMatrix obj = new ShortestPathInBinaryMatrix();

        System.out.println(obj.shortestPathBinaryMatrix(grid));
    }
    public int shortestPathBinaryMatrix(int[][] grid) {

        if(grid==null || grid.length==0){
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        if(grid[0][0]==1 || grid[rows-1][cols-1]==1){
            return -1;
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});

        boolean visited[][] = new boolean[rows][cols];
        visited[0][0] = true;

        int moves = 0;

        int dirs[][] = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};

        while(!q.isEmpty()){

            int size = q.size();

            moves++;

            for(int i=0;i<size;i++){

                int cell[] = q.remove();
                int rcell = cell[0];
                int ccell = cell[1];

                if(rcell==rows-1 && ccell==cols-1){
                    return moves;
                }

                for(int j=0;j<dirs.length;j++){

                    int newRow = rcell + dirs[j][0];
                    int newCol = ccell + dirs[j][1];

                    if(isValid(grid,newRow,newCol,rows,cols,visited)){

                        q.add(new int[]{newRow,newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
        }

        return -1;
    }

    public boolean isValid(int grid[][],int row,int col,int rows,int cols,boolean visited[][]){

        if(row<0 || row>=rows || col<0 || col>=cols || grid[row][col]==1 || visited[row][col]){
            return false;
        }
        return true;
    }
}
