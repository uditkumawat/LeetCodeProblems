package code.facebook;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/shortest-path-in-binary-matrix/solution/
public class ShortestPathInBinaryMatrix {

    private static int directions[][] = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};

    public static void main(String args[]){

        int matrix[][] = {{0,1},{1,0}};

        ShortestPathInBinaryMatrix obj = new ShortestPathInBinaryMatrix();

        System.out.println(obj.shortestPathBinaryMatrix(matrix));
    }
    public int shortestPathBinaryMatrix(int[][] grid) {

        if(grid==null || grid.length==0 || grid[0][0]!=0 || grid[grid.length-1][grid[0].length-1]!=0){
            return 0;
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,0});
        grid[0][0] = 1;

        while(!q.isEmpty()){
            int node[] = q.poll();
            int row = node[0];
            int col = node[1];
            int distance = node[2];

            if(row==grid.length-1 && col==grid[0].length-1){
                return distance+1;
            }

            for(int i=0;i<directions.length;i++){
                int newRow = row+directions[i][0];
                int newCol = col+directions[i][1];

                if(isValid(grid,newRow,newCol,grid.length,grid[0].length)){
                    q.add(new int[]{newRow,newCol,distance+1});
                    grid[newRow][newCol] = 1;
                }
            }
        }

        return -1;
    }

    public boolean isValid(int grid[][],int row,int col,int rows,int cols){
        if(row<0 || row>=rows || col<0 || col>=cols || grid[row][col]!=0){
            return false;
        }
        return true;
    }
}
