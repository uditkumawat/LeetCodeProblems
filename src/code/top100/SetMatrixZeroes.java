package code.top100;

//TC - O(M*N)
//SC - O(1)
public class SetMatrixZeroes {

    public static void main(String args[]){

        int matrix[][] = {{1,1,1},{1,0,1},{1,1,1}};

        setMatrixZeroes(matrix);

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void setMatrixZeroes(int matrix[][]) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int trows = matrix.length;
        int tcols = matrix[0].length;
        boolean isFirstRowZero = false;
        boolean isFirstColumnZero = false;

        //check for first column
        for (int i = 0; i < trows; i++) {
            if (matrix[i][0] == 0) {
                isFirstColumnZero = true;
                break;
            }
        }


        //check for first row
        for (int i = 0; i < tcols; i++) {
            if (matrix[0][i] == 0) {
                isFirstRowZero = true;
                break;
            }
        }


        for (int i = 1; i < trows; i++) {
            for (int j = 1; j < tcols; j++) {

                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }


        for (int i = 1; i < trows; i++) {
            for (int j = 1; j < tcols; j++) {

                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (isFirstRowZero) {
            for (int i = 0; i < tcols; i++) {
                matrix[0][i] = 0;
            }
        }


        if (isFirstColumnZero) {
            for (int i = 0; i < trows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
