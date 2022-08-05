package code.tagged.facebook;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/shortest-path-in-binary-matrix/
//TC - O(M*N)
//SC - O(M*N)
public class ShortestPathInBinaryMatrix {

    public static void main(String args[]){

        int grid[][] = {{0,1},{1,0}};

        ShortestPathInBinaryMatrix obj = new ShortestPathInBinaryMatrix();
        System.out.println(obj.shortestPathBinaryMatrix(grid));
    }
    public int shortestPathBinaryMatrix(int[][] grid) {

        if(grid==null || grid.length==0 || grid[0].length==0){
            return -1;
        }

        if(grid[0][0]==1 || grid[grid.length-1][grid[0].length-1]==1){
            return -1;
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        grid[0][0] = 1;

        int directions[][] = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        int len = 1;

        while(!q.isEmpty()){

            int size = q.size();

            for(int i=0;i<size;i++){

                int node[] = q.poll();

                if(node[0]==grid.length-1 && node[1]==grid[0].length-1){
                    return len;
                }

                for(int j=0;j<directions.length;j++){

                    int newX = node[0]+directions[j][0];
                    int newY = node[1]+directions[j][1];

                    if(isValid(grid,newX,newY)){

                        q.add(new int[]{newX,newY});
                        grid[newX][newY] = 1;
                    }
                }
            }

            len++;
        }

        return -1;
    }

    private boolean isValid(int grid[][],int row,int col){

        if(row<0 || row>grid.length || col<0 || col>grid[0].length || grid[row][col]!=0){
            return false;
        }
        return true;
    }
}
