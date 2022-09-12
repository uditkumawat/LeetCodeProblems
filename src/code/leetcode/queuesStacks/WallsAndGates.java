package code.leetcode.queuesStacks;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/walls-and-gates/
//TC - O(m*n)
//SC - O(m*n)
public class WallsAndGates {

    public void wallsAndGates(int[][] rooms) {

        if(rooms==null || rooms.length==0){
            return;
        }

        int rows = rooms.length;
        int cols = rooms[0].length;
        Queue<int[]> q = new LinkedList();

        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(rooms[row][col]==0){
                    q.add(new int[]{row,col});
                }
            }
        }

        int dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};

        while(!q.isEmpty()){

            int top[] = q.remove();

            int currRow = top[0];
            int currCol = top[1];

            for(int dir=0;dir<dirs.length;dir++){

                int newRow = currRow+dirs[dir][0];
                int newCol = currCol+dirs[dir][1];

                if(isValid(rooms,newRow,newCol,rows,cols)){
                    rooms[newRow][newCol] = rooms[currRow][currCol]+1;
                    q.add(new int[]{newRow,newCol});
                }
            }
        }
    }

    public boolean isValid(int rooms[][],int row,int col,int rows,int cols){

        if(row<0 || row>=rows || col<0 || col>=cols || rooms[row][col]!=Integer.MAX_VALUE){
            return false;
        }
        return true;
    }
}
