package code.june.challenge;

//https://leetcode.com/problems/transpose-matrix/submissions/
//TC - O(R*C)
//SC - O(R*C)
public class TransposeAMatrix {

    public int[][] transpose(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int res[][] = new int[cols][rows];

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                res[c][r] = matrix[r][c];
            }
        }

        return res;
    }
}
