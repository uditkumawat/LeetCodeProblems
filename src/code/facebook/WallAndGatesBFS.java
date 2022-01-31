package code.facebook;

import java.util.LinkedList;
import java.util.Queue;

/**
 *Time complexity : O(mn)O(mn).
 *
 * If you are having difficulty to derive the time complexity, start simple.
 *
 * Let us start with the case with only one gate. The breadth-first search takes at most m \times nm×n steps to reach all rooms, therefore the time complexity is O(mn)O(mn). But what if you are doing breadth-first search from kk gates?
 *
 * Once we set a room's distance, we are basically marking it as visited, which means each room is visited at most once. Therefore, the time complexity does not depend on the number of gates and is O(mn)O(mn).
 *
 * Space complexity : O(mn)O(mn). The space complexity depends on the queue's size. We insert at most m \times nm×n points into the queue.
 */
public class WallAndGatesBFS {

    public void wallsAndGates(int[][] rooms) {

        if(rooms==null || rooms.length==0){
            return;
        }

        int rows = rooms.length;
        int cols = rooms[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int row=0;row<rows;row++){
            for(int col=0;cols<cols;col++){
                if(rooms[row][col]==0){
                    q.add(new int[]{row,col});
                }
            }
        }

        int dirs[][] = {{0,1},{0,-1},{1,0},{-1,0}};

        while(!q.isEmpty()){
            int point[] = q.poll();

            int row = point[0];
            int col = point[1];

            for(int dir[]:dirs){
                int newRow = row+dir[0];
                int newCol = col+dir[1];

                if(newRow<0 || newRow>=rows || newCol<0 || newCol>=cols || rooms[newRow][newCol]!=Integer.MAX_VALUE-1){
                    continue;
                }

                rooms[newRow][newCol] = rooms[row][col]+1;
                q.add(new int[]{newRow,newCol});
            }
        }
    }
}
