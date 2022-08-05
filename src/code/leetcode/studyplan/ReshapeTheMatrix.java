package code.leetcode.studyplan;

//https://leetcode.com/problems/reshape-the-matrix/solution/
//TC-O(M*N)

public class ReshapeTheMatrix {

    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int crows = mat.length;
        int ccols = mat[0].length;

        int n = crows * ccols;

        if(n!=r*c){
            return mat;
        }

        int newMat[][] = new int[r][c];

        int k=0;
        for(int i=0;i<crows;i++){
            for(int j=0;j<ccols;j++){
                newMat[k/c][k%c] = mat[i][j];
                k++;
            }
        }

        return newMat;
    }
}
