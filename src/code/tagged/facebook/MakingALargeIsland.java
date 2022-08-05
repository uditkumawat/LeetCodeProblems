package code.tagged.facebook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://www.youtube.com/watch?v=ggEq5JrnmH0
//TC - O(N*N)
//SC - O(N*N) recursion depth
public class MakingALargeIsland {

    public static void main(String args[]){

        int grid[][] = {{1,0},{0,1}};

        MakingALargeIsland obj = new MakingALargeIsland();

        System.out.println(obj.largestIsland(grid));

    }
    public int largestIsland(int[][] grid) {

        if(grid==null || grid.length==0){
            return 0;
        }

        Map<Integer,Integer> map = new HashMap();
        map.put(0,0);
        map.put(1,0);

        int gridId = 2;
        int size = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    size = getArea(grid,i,j,gridId);
                    map.put(gridId,size);
                    gridId++;
                }
            }
        }

        int maxArea = map.getOrDefault(2,0);

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==0){

                    Set<Integer> set = new HashSet();

                    set.add(i>0 ? grid[i-1][j]:0);
                    set.add(i<grid.length-1 ? grid[i+1][j]:0);
                    set.add(j>0 ? grid[i][j-1]:0);
                    set.add(j<grid[i].length-1 ? grid[i][j+1]:0);

                    int totalSize = 1;
                    for(int id:set){
                        totalSize = totalSize + map.get(id);
                    }

                    maxArea = Math.max(maxArea,totalSize);
                }
            }
        }

        return maxArea;

    }

    public int getArea(int grid[][],int row,int col,int id){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]!=1){
            return 0;
        }

        grid[row][col] = id;

        return 1+getArea(grid,row+1,col,id)+getArea(grid,row-1,col,id)+getArea(grid,row,col+1,id)+getArea(grid,row,col-1,id);
    }
}
