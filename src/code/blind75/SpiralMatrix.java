package code.blind75;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/spiral-matrix/solution/
//TC - O(M*N)
//SC - O(1)
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();

        if(matrix==null || matrix.length==0){
            return res;
        }

        int startRow = 0;
        int endRow = matrix.length-1;
        int startColumn = 0;
        int endColumn = matrix[0].length-1;

        while(startRow<=endRow && startColumn<=endColumn){

            for(int i=startColumn;i<=endColumn;i++){
                res.add(matrix[startRow][i]);
            }

            startRow++;

            for(int i=startRow;i<=endRow;i++){
                res.add(matrix[i][endColumn]);
            }

            endColumn--;

            //this is to make sure, we should not traverse the same row or columns
            if(startRow<=endRow){
                for(int i=endColumn;i>=startColumn;i--){
                    res.add(matrix[endRow][i]);
                }

                endRow--;
            }

            if(startColumn<=endColumn){
                for(int i=endRow;i>=startRow;i--){
                    res.add(matrix[i][startColumn]);
                }

                startColumn++;
            }
        }

        return res;
    }
}
