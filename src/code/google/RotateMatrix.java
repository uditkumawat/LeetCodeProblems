package code.google;

//https://www.youtube.com/watch?v=SA867FvqHrM
public class RotateMatrix {

    public static void main(String args[]){

        int matrix[][] = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};

        RotateMatrix obj = new RotateMatrix();

        obj.rotate(matrix);

        for(int row[]:matrix){
            for(int num:row){
                System.out.print(num+" ");
            }
            System.out.println();
        }

    }
    public void rotate(int[][] matrix) {

        if(matrix==null || matrix.length==0){
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        transpose(matrix, rows,cols);

        reverseRows(matrix, rows, cols);

        return;
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

    public void reverseRows(int matrix[][],int rows,int cols){
        for(int i=0;i<rows;i++){
            int left = 0;
            int right = matrix[i].length-1;
            while(left<=right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
