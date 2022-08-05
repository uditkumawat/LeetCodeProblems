package code.graph;

import java.util.*;

//https://leetcode.com/problems/pacific-atlantic-water-flow/solution
//TC - O(M*N)
//SC - O(M*N)
public class PacificAtlanticWaterFlow {

    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private int numRows;
    private int numCols;
    private int[][] landHeights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        if(heights==null || heights.length==0){
            return new ArrayList<>();
        }

        numRows = heights.length;
        numCols = heights[0].length;
        landHeights = heights;

        Queue<int[]> pq = new LinkedList<>();
        Queue<int[]> aq = new LinkedList<>();

        for(int i=0;i<numRows;i++){
            pq.add(new int[]{i,0});
            aq.add(new int[]{i,numCols-1});
        }

        for(int i=0;i<numCols;i++){
            pq.add(new int[]{0,i});
            aq.add(new int[]{numRows-1,i});
        }

        boolean[][] pacificReachable = bfs(pq);
        boolean[][] atlanticReachable = bfs(aq);

        // Find all cells that can reach both oceans
        List<List<Integer>> commonCells = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    commonCells.add(Arrays.asList(i, j));
                }
            }
        }
        return commonCells;
    }

    private boolean[][] bfs(Queue<int[]> queue) {
        boolean[][] reachable = new boolean[numRows][numCols];
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            // This cell is reachable, so mark it
            reachable[cell[0]][cell[1]] = true;
            for (int[] dir : DIRECTIONS) { // Check all 4 directions
                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[1];
                // Check if new cell is within bounds
                if (newRow < 0 || newRow >= numRows || newCol < 0 || newCol >= numCols) {
                    continue;
                }
                // Check that the new cell hasn't already been visited
                if (reachable[newRow][newCol]) {
                    continue;
                }
                // Check that the new cell has a higher or equal height,
                // So that water can flow from the new cell to the old cell
                if (landHeights[newRow][newCol] < landHeights[cell[0]][cell[1]]) {
                    continue;
                }
                // If we've gotten this far, that means the new cell is reachable
                queue.offer(new int[]{newRow, newCol});
            }
        }
        return reachable;
    }

}
