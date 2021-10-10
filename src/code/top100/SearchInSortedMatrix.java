package code.top100;

//TC - O(m+n)

/**
 * The key to the time complexity analysis is noticing that, on every iteration (during which we do not return true) either row or col is is decremented/incremented exactly once. Because row can only be decremented mm times and col can only be incremented nn times before causing the while loop to terminate, the loop cannot run for more than n+mn+m iterations. Because all other work is constant, the overall time complexity is linear in the sum of the dimensions of the matrix.
 */
public class SearchInSortedMatrix {

    public static void main(String args[]){

        int matrix[][] = {{1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}};
        int target = 3;

        System.out.println(searchMatrix(matrix,target));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {

        if(matrix==null || matrix.length==0){
            return false;
        }

        int row = 0;
        int col = matrix[0].length-1;

        while(row<matrix.length && col>=0){
            if(matrix[row][col]==target){
                return true;
            }
            else if(matrix[row][col]>target){
                col--;
            }
            else{
                row++;
            }
        }

        return false;
    }
}
