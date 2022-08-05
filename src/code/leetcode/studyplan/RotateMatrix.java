package code.leetcode.studyplan;

//https://leetcode.com/problems/rotate-image/solution/
//TC-O(M)

/**
 * Let MM be the number of cells in the grid.
 *
 * Time complexity : \mathcal{O}(M)O(M). We perform two steps; transposing the matrix, and then reversing each row. Transposing the matrix has a cost of \mathcal{O}(M)O(M) because we're moving the value of each cell once. Reversing each row also has a cost of \mathcal{O}(M)O(M), because again we're moving the value of each cell once.
 */
public class RotateMatrix {

    public void rotate(int[][] matrix) {

        if(matrix==null || matrix.length==0){
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        transpose(matrix,rows,cols);

        rotateEachRow(matrix,rows,cols);
    }

    public void transpose(int matrix[][],int rows,int cols){

        for(int i=0;i<rows;i++){
            for(int j=i;j<cols;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void rotateEachRow(int matrix[][],int rows,int cols){

        for(int i=0;i<rows;i++){

            swap(matrix[i],0,cols-1);
        }
    }

    public void swap(int arr[],int left,int right){

        while(left<=right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
