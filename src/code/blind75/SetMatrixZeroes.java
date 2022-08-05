package code.blind75;

//https://leetcode.com/problems/set-matrix-zeroes/
//TC - O(M*n)
//SC - O(1)
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {

        if(matrix==null || matrix.length==0){
            return;
        }

        int numRows = matrix.length;
        int numCols = matrix[0].length;
        boolean firstRow = false;
        boolean firstColumn = false;

        //checking first row
        for(int i=0;i<numCols;i++){
            if(matrix[0][i]==0){
                firstRow = true;
                break;
            }
        }

        //checking first column
        for(int i=0;i<numRows;i++){
            if(matrix[i][0]==0){
                firstColumn = true;
                break;
            }
        }

        for(int i=1;i<numRows;i++){
            for(int j=1;j<numCols;j++){
                if(matrix[i][j]==0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i=1;i<numRows;i++){
            for(int j=1;j<numCols;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(firstRow){
            for(int i=0;i<numCols;i++){
                matrix[0][i] = 0;
            }
        }


        if(firstColumn){
            for(int i=0;i<numRows;i++){
                matrix[i][0] = 0;
            }
        }

    }
}
