package code.amazon;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/shortest-path-to-get-food/
//TC - O(M*N)
public class ShortestPathToGetFood {

    public static void main(String args[]){

        char grid[][] = {{'X','X','X','X','X','X','X','X'},{'X','*','O','X','O','#','O','X'},{'X','O','O','X','O','O','X','X'},{'X','O','O','O','O','#','O','X'},{'X','X','X','X','X','X','X','X'}};
        ShortestPathToGetFood obj = new ShortestPathToGetFood();

        System.out.println(obj.getFood(grid));
    }
    public int getFood(char[][] grid) {

        if(grid==null || grid.length==0){
            return -1;
        }

        return getShortestPath(grid);
    }

    public int getShortestPath(char grid[][]){

        int rows = grid.length;
        int cols = grid[0].length;

        int startX = -1;
        int startY = -1;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='*'){
                    startX = i;
                    startY = j;
                    break;
                }
            }
        }

        if(startX==-1 && startY==-1){
            return -1;
        }

        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        q.add(new Pair(startX,startY));

        boolean visited[][] = new boolean[rows][cols];
        visited[startX][startY] = true;

        int moves = 0;

        int dirs[][] = {{1,0},{0,1},{-1,0},{0,-1}};

        while(!q.isEmpty()){

            int size = q.size();

            moves++;

            while(size-->0){

                Pair<Integer,Integer> p = q.poll();

                for(int i=0;i<dirs.length;i++){

                    int newX = p.getKey()+dirs[i][0];
                    int newY = p.getValue()+dirs[i][1];

                    if(isValid(grid,newX,newY,rows,cols,visited)){

                        if(grid[newX][newY]=='#'){
                            return moves;
                        }

                        q.add(new Pair(newX,newY));
                        visited[newX][newY] = true;
                    }
                }
            }
        }

        return -1;
    }

    public boolean isValid(char grid[][],int row,int col,int rows,int cols,boolean visited[][]){

        if(row<0 || row>=rows || col<0 || col>=cols || grid[row][col]=='X' || visited[row][col]){
            return false;
        }
        return true;
    }
}
