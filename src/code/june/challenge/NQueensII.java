package code.june.challenge;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/n-queens-ii/submissions/
//TC - O(n!)
public class NQueensII {

    Set<Integer> colIndex;
    Set<Integer> diagonalIndex;
    Set<Integer> antiDiagonalIndex;

    int count;

    public int totalNQueens(int n) {

        count = 0;
        colIndex = new HashSet();
        diagonalIndex = new HashSet();
        antiDiagonalIndex = new HashSet();
        findSolutions(n,0);

        return count;
    }

    public void findSolutions(int n,int row){
        if(row==n){
            count++;
            return;
        }

        for(int col=0;col<n;col++){

            if(isValid(row,col)){

                colIndex.add(col);
                diagonalIndex.add(row-col);
                antiDiagonalIndex.add(row+col);

                findSolutions(n,row+1);

                colIndex.remove(col);
                diagonalIndex.remove(row-col);
                antiDiagonalIndex.remove(row+col);
            }
        }
    }

    private boolean isValid(int row,int col){
        if(colIndex.contains(col) || diagonalIndex.contains(row-col) || antiDiagonalIndex.contains(row+col)){
            return false;
        }
        return true;
    }
}
