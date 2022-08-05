package code.dp;

//https://leetcode.com/problems/matrix-block-sum/
//https://www.youtube.com/watch?v=2RxD2GTzMLw
public class MatrixBlockSum {

    public int[][] matrixBlockSum(int[][] mat, int k) {

        int rows = mat.length;
        int cols = mat[0].length;

        int ans[][] = new int[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                for(int x=-k;x<=k;x++){
                    if(i+x>=0 && i+x<rows){

                        int leftColumn = Math.max(j-k,0);
                        int rightColumn = j+k+1;

                        ans[i+x][leftColumn]+= mat[i][j];

                        if(rightColumn<cols){
                            ans[i+x][rightColumn]-=mat[i][j];
                        }
                    }
                }
            }
        }

        int sum = 0;

        for(int i=0;i<rows;i++){
            sum = 0;
            for(int j=0;j<cols;j++){
                sum = sum + ans[i][j];
                ans[i][j] = sum;
            }
        }

        return ans;
    }
}
