package code.leetcode.doordash;

public class CountOfSquareSubMatrices {

    public static void main(String args[]){
        int matrix[][]={{0,1,0},{1,1,1},{1,1,1}};
        int rows = matrix.length;
        int cols = matrix[0].length;

        System.out.println(count(matrix,rows,cols));

    }

    public static int count(int matrix[][],int rows,int cols){

        int dp[][] = new int[rows][cols];

        int count=0;

        for(int i=0;i<rows;i++){
            dp[i][0] = matrix[i][0];
            count+=dp[i][0];
        }

        for(int i=0;i<cols;i++){
            dp[0][i] = matrix[0][i];
            count+=dp[0][i];
        }

        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                dp[i][j]=1+Math.min(matrix[i][j-1],Math.min(matrix[i-1][j-1],matrix[i-1][j]));
                count+=dp[i][j];
            }
        }

        return count;
    }
}
