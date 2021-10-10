package code.top100;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/shortest-path-in-binary-matrix/solution/
public class ShortestPathInBinaryMatrix {

    public static void main(String args[]){

        /**
        int grid[][] = {{0,0,0,0,1},
                {1,0,0,0,0},
                {0,1,0,1,0},
                {0,0,0,1,1},
                {0,0,0,1,0}};
    */
        int grid[][] = {{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(minimumMoves(grid));
    }

    public static int minimumMoves(int grid[][]){

        if(grid==null || grid.length==0){
            return 0;
        }

        if(grid[0][0]!=0 || grid[grid.length-1][grid[0].length-1]!=0){
            return -1;
        }

        int rows = grid.length-1;  // as it is 0 based indexing for checking
        int cols = grid[0].length-1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1});

        boolean visited[][] = new boolean[rows+1][cols+1];
        visited[0][0] = true;

        int dirs[][] = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++) {
                int curr[] = q.remove();
                if (curr[0] == rows && curr[1] == cols){
                    return curr[2];
                }

                for(int j=0;j<dirs.length;j++){

                    int newx = curr[0]+dirs[j][0];
                    int newy = curr[1]+dirs[j][1];
                    int newDistance = curr[2]+1;

                    if(newx>=0 && newy>=0 && newx<=rows && newy<=cols && !visited[newx][newy] && grid[newx][newy]==0){
                        q.add(new int[]{newx,newy,newDistance});
                        visited[newx][newy] = true;
                    }
                }
            }
        }

        return -1;
    }
}
