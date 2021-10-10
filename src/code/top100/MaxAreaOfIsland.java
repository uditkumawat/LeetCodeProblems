package code.top100;

public class MaxAreaOfIsland {

    public static void main(String args[]){

        int grid[][] = {{1,1,1,1},{1,1,0,0,},{0,0,0,1},{1,1,1,1}};

        System.out.println(getMaxArea(grid));
    }

    public static int getMaxArea(int grid[][]){

        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    int area = getArea(grid,i,j,rows,cols);
                    maxArea = Math.max(maxArea,area);
                }
            }
        }

        return maxArea;
    }

    public static int getArea(int grid[][],int i,int j,int rows,int cols){

        if(i<0 || i>=rows || j<0 || j>=cols){
            return 0;
        }

        if(grid[i][j]==0){
            return 0;
        }

        grid[i][j] = 0;

        int up = getArea(grid,i-1,j,rows,cols);
        int down = getArea(grid,i+1,j,rows,cols);
        int left = getArea(grid,i,j-1,rows,cols);
        int right = getArea(grid,i,j+1,rows,cols);

        return left+right+up+down+1;
    }
}
