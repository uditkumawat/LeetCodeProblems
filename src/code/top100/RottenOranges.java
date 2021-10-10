package code.top100;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/rotting-oranges/solution/
public class RottenOranges {

    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length == 0) return -1;

        int count_fresh = 0;
        Queue<Pair<Integer,Integer>> queue = new LinkedList();
        int R = grid.length, C = grid[0].length;

        for(int r = 0; r < R; r++)
            for(int c = 0; c < C; c++)
                if(grid[r][c] == 2) queue.offer(new Pair(r,c));
                else if(grid[r][c]==1) count_fresh++;

        if(count_fresh==0) return 0;

        int count = 0;
        int dirs[][] = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

        while(!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for(int i = 0;i<size;i++){
                Pair<Integer,Integer> pair = queue.poll();
                int row = pair.getKey();
                int col = pair.getValue();
                for(int[] dir:dirs){
                    int r = row+dir[0];
                    int c = col+dir[1];
                    if(r<0 || r>=R || c<0 || c>=C || grid[r][c] == 0 || grid[r][c] == 2) continue;

                    grid[r][c] = 2;
                    queue.add(new Pair(r,c));
                    count_fresh--;

                }
            }
        }
        return count_fresh==0?count -1 : -1;
    }
}
