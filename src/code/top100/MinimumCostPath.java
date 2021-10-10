package code.top100;

//TC - O(M*N)
//SC - O(1)
public class MinimumCostPath {

    public static void main(String args[]){

        int matrix[][] = {{1,3,1},{1,5,1},{4,2,1}};

        System.out.println(minCostPath(matrix));
    }

    public static int minCostPath(int matrix[][]){

        for(int i=1;i<matrix.length;i++){
            matrix[i][0] = matrix[i-1][0]+matrix[i][0];
        }

        for(int i=1;i<matrix[0].length;i++){
            matrix[0][i] = matrix[0][i-1]+matrix[0][i];
        }

        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                matrix[i][j] = matrix[i][j]+Math.min(matrix[i-1][j],matrix[i][j-1]);
            }
        }

        return matrix[matrix.length-1][matrix[0].length-1];
    }
}
