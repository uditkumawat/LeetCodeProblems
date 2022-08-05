package code.leetcode.studyplan75;

//https://leetcode.com/problems/search-a-2d-matrix-ii/submissions/
//TC -O(m+n)
public class SearchIn2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null){
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int i = 0;
        int j = cols-1;

        while(j>=0 && i<rows){
            if(matrix[i][j]==target){
                return true;
            }
            else if(matrix[i][j]>target){
                j--;
            }
            else{
                i++;
            }
        }

        return false;
    }
}
