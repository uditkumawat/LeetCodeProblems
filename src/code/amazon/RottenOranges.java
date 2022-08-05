package code.amazon;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * //https://leetcode.com/problems/rotting-oranges/
 *
 * Time Complexity: \mathcal{O}(N)O(N), where NN is the size of the grid.
 *
 * First, we scan the grid to find the initial values for the queue, which would take \mathcal{O}(N)O(N) time.
 *
 * Then we run the BFS process on the queue, which in the worst case would enumerate all the cells in the grid once and only once. Therefore, it takes \mathcal{O}(N)O(N) time.
 *
 * Thus combining the above two steps, the overall time complexity would be \mathcal{O}(N) + \mathcal{O}(N) = \mathcal{O}(N)O(N)+O(N)=O(N)
 *
 * Space Complexity: \mathcal{O}(N)O(N), where NN is the size of the grid.
 *
 * In the worst case, the grid is filled with rotten oranges. As a result, the queue would be initialized with all the cells in the grid.
 *
 * By the way, normally for BFS, the main space complexity lies in the process rather than the initialization. For instance, for a BFS traversal in a tree, at any given moment, the queue would hold no more than 2 levels of tree nodes. Therefore, the space complexity of BFS traversal in a tree would depend on the width of the input tree.
 */
public class RottenOranges {

    public static void main(String args[]){

        int grid[][] = {{2,1,1},{0,1,1},{1,0,1}};

        RottenOranges obj = new RottenOranges();

        System.out.println(obj.orangesRotting(grid));

    }
    public int orangesRotting(int[][] grid) {

        if(grid==null || grid.length==0){
            return -1;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        int freshOranges = 0;
        int minutes = 0;
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    freshOranges++;
                }
                else if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }
            }
        }

        int dirs[][] = {{1,0},{0,1},{-1,0},{0,-1}};

        while(!q.isEmpty() && freshOranges>0){

            int size = q.size();

            while(size-->0){
                Pair<Integer,Integer> pair = q.poll();
                int x = pair.getKey();
                int y = pair.getValue();

                for(int i=0;i<dirs.length;i++){

                    int newX = x + dirs[i][0];
                    int newY = y + dirs[i][1];

                    if(isValid(grid,newX,newY,rows,cols)){
                        q.add(new Pair(newX,newY));
                        grid[newX][newY] = 2;
                        freshOranges--;
                    }
                }
            }

            minutes++;
        }

        return freshOranges==0 ? minutes:-1;

    }

    private boolean isValid(int grid[][],int row,int col,int rows,int cols){
        if(row<0 || row>=rows || col<0 || col>=cols || grid[row][col]==0 || grid[row][col]==2){
            return false;
        }
        return true;
    }
}
