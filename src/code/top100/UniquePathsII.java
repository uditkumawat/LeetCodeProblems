package code.top100;

//TC - O(n*n)
public class UniquePathsII {

    public static void main(String args[]){

        int matrix[][] = {{0,0,1,0},{0,1,0,0,},{0,0,0,0},{0,1,0,0}};

        System.out.println(uniquePaths(matrix));
    }

    public static int uniquePaths(int matrix[][]){

        int rows = matrix.length;
        int cols = matrix[0].length;

        int dp[][] = new int[rows][cols];

        dp[0][0]=1;
        for(int i=0;i<cols;i++){
            //found an obstacle
            if(matrix[0][i]==1){
                break;
            }
            dp[0][i] = 1;
        }


        for(int i=0;i<rows;i++){
            //found an obstacle
            if(matrix[i][0]==1){
                break;
            }
            dp[0][i] = 1;
        }

        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                if(matrix[i][j]==1){
                    dp[i][j] = 0;
                }
                else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }

        return dp[rows-1][cols-1];
    }
}
