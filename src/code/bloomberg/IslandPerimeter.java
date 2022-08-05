package code.bloomberg;

//https://leetcode.com/problems/island-perimeter/solution/
//TC - O(m*n)
public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {

        int count = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){

                if(grid[i][j]==1){

                    if(i>0){
                        if(grid[i-1][j]==0){
                            count++;
                        }
                    }
                    else if(i==0){
                        count++;
                    }

                    if(j<grid[i].length-1){
                        if(grid[i][j+1]==0){
                            count++;
                        }
                    }
                    else if(j==grid[i].length-1){
                        count++;
                    }

                    if(i<grid.length-1){
                        if(grid[i+1][j]==0){
                            count++;
                        }
                    }
                    else if(i==grid.length-1){
                        count++;
                    }

                    if(j>0){
                        if(grid[i][j-1]==0){
                            count++;
                        }
                    }
                    else if(j==0){
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
