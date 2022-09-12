package code.leetcode.queuesStacks;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    int dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};

    public int numIslands(char[][] grid) {

        if(grid==null || grid.length==0){
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(grid[row][col]=='1'){
                    count++;
                    bfs(grid,row,col,rows,cols);
                }
            }
        }

        return count;
    }

    public void bfs(char grid[][],int row,int col,int rows,int cols){

        Queue<int[]> q = new LinkedList();

        q.add(new int[]{row,col});
        grid[row][col]='0';

        while(!q.isEmpty()){

            int top[] = q.remove();
            int currRow = top[0];
            int currCol = top[1];

            for(int dir=0;dir<dirs.length;dir++){

                int newRow = currRow + dirs[dir][0];
                int newCol = currCol + dirs[dir][1];

                if(isValid(grid,newRow,newCol,rows,cols)){
                    grid[newRow][newCol] = '0';
                    q.add(new int[]{newRow,newCol});
                }
            }
        }
    }

    public boolean isValid(char grid[][],int row,int col,int rows,int cols){

        if(row<0 || row>=rows || col<0 || col>=cols || grid[row][col]!='1'){
            return false;
        }
        return true;
    }
}
