package code.google;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathWithObstaclesElimination {

    public static void main(String args[]){

        int grid[][] = {{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};

        ShortestPathWithObstaclesElimination obj = new ShortestPathWithObstaclesElimination();
        int k = 1;
        System.out.println(obj.shortestPath(grid,k));
    }
    public int shortestPath(int[][] grid, int k) {

        if(grid==null || grid[0].length==0){
            return -1;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int steps = 0;
        boolean visited[][] = new boolean[rows][cols];

        q.add(new int[]{0,0});
        visited[0][0] = true;

        int directions[][] = {{-1,0},{0,1},{1,0},{0,-1}};

        while(!q.isEmpty()){

            int size = q.size();
            boolean isObstaclePresent = false;
            for(int i=0;i<size;i++){

                int node[] = q.poll();
                int x = node[0];
                int y = node[1];

                if(x==grid.length-1 && y==grid[0].length-1){
                    return steps;
                }
                for(int j=0;j<directions.length;j++){

                    int newX = x+directions[j][0];
                    int newY = y+directions[j][1];

                    if(isValid(grid,newX,newY,visited)){
                        if(grid[newX][newY]==1){

                            isObstaclePresent = true;
                            q.add(new int[]{newX,newY});
                            visited[newX][newY] = true;
                        }
                        else{
                            if(grid[newX][newY]==0){
                                q.add(new int[]{newX,newY});
                                visited[newX][newY] = true;
                            }
                        }
                    }
                }

                if(isObstaclePresent){
                    k--;
                }
            }
            steps++;
        }

        return -1;
    }

    private boolean isValid(int grid[][],int x,int y,boolean visited[][]){

        return x>=0 && x<grid.length && y>=0 && y<grid[0].length && visited[x][y]==false;
    }
}
