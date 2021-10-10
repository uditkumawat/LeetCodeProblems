package code.microsoft;

/**
 * Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.
 */

public class CountNegativeNumbersInSortedMatrix {

    public static void main(String args[]){

        CountNegativeNumbersInSortedMatrix obj = new CountNegativeNumbersInSortedMatrix();
        int grid[][] = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};

        System.out.println(obj.countNegatives(grid));
    }

    public int countNegatives(int[][] grid) {

        if(grid==null || grid.length==0){
            return 0;
        }

        int count = 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int row = 0;
        int col = cols-1;

        while(row<rows && col>=0){
            if(grid[row][col]<0){
                col--;
                count+=rows-row;
            }
            else{
                row++;
            }
        }

        return count;
    }
}
