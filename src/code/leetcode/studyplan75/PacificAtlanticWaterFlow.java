package code.leetcode.studyplan75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.youtube.com/watch?v=NaBu9YgbaDM
//https://leetcode.com/problems/pacific-atlantic-water-flow/
//TC - O(n^2)
//SC - O(n^2)
public class PacificAtlanticWaterFlow {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> res = new ArrayList();

        if(heights==null || heights.length==0){
            return res;
        }

        int m = heights.length;
        int n = heights[0].length;

        boolean pacific[][] = new boolean[m][n];
        boolean atlantic[][] = new boolean[m][n];

        for(int i=0;i<m;i++){
            dfs(i,0,heights,pacific,Integer.MIN_VALUE);
            dfs(i,n-1,heights,atlantic,Integer.MIN_VALUE);
        }

        for(int i=0;i<n;i++){
            dfs(0,i,heights,pacific,Integer.MIN_VALUE);
            dfs(m-1,i,heights,atlantic,Integer.MIN_VALUE);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }

        return res;

    }

    public void dfs(int row,int col,int heights[][],boolean visited[][],int prevHeight){

        if(row<0 || col<0 || row>=heights.length || col>=heights[0].length || visited[row][col] || heights[row][col]<prevHeight){
            return;
        }

        visited[row][col] = true;

        dfs(row+1,col,heights,visited,heights[row][col]);
        dfs(row,col+1,heights,visited,heights[row][col]);
        dfs(row-1,col,heights,visited,heights[row][col]);
        dfs(row,col-1,heights,visited,heights[row][col]);

    }

}
