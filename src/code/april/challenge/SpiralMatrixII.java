package code.april.challenge;

//https://leetcode.com/problems/spiral-matrix-ii/
//TC - O(n*n)
//SC - O(1)
public class SpiralMatrixII {

    public static void main(String args[]){

        int n = 1;

        SpiralMatrixII obj = new SpiralMatrixII();

        int matrix[][] = obj.generateMatrix(n);

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }
    public int[][] generateMatrix(int n) {

        int matrix[][] = new int[n][n];

        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n-1;

        int num = 1;

        while(num<=n*n){

            for(int i=left;i<=right;i++){
                matrix[top][i] = num++;
            }

            top++;

            for(int i=top;i<=bottom;i++){
                matrix[i][right] = num++;
            }

            right--;

            for(int i=right;i>=left;i--){
                matrix[bottom][i] = num++;
            }

            bottom--;

            for(int i=bottom;i>=top;i--){
                matrix[i][left] = num++;
            }

            left++;
        }

        return matrix;
    }
}
