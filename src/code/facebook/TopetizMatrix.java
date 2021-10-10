package code.facebook;

/**
 * Time Complexity: O(M*N)O(M∗N), as defined in the problem statement.
 *
 * Space Complexity: O(1)O(1).
 */
public class TopetizMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {

        for(int r=0;r<matrix.length;r++){
            for(int c=0;c<matrix[r].length;c++){
                if(r>0 && c>0 && matrix[r-1][c-1]!=matrix[r][c]){
                    return false;
                }
            }
        }

        return true;
    }
}
