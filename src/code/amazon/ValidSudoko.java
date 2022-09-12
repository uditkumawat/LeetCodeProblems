package code.amazon;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/valid-sudoku/submissions/
public class ValidSudoko {

    Set<Integer> rows[];
    Set<Integer> cols[];
    Set<Integer> boxes[];
    public boolean isValidSudoku(char[][] board) {

        if(board==null || board.length==0){
            return false;
        }

        int n = board.length;

        rows = new HashSet[n];
        cols = new HashSet[n];
        boxes = new HashSet[n];

        for(int i=0;i<n;i++){
            rows[i] = new HashSet<Integer>();
            cols[i] = new HashSet<Integer>();
            boxes[i] = new HashSet<Integer>();
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                char c = board[i][j];
                if(c!='.'){
                    int val = c-'0';
                    int boxId = 3*(i/3) + (j/3);

                    // System.out.println(val+" "+boxId);
                    if(isNotValid(i,j,val)){
                        return false;
                    }
                    rows[i].add(val);
                    cols[j].add(val);
                    boxes[boxId].add(val);
                }
            }
        }

        return true;
    }

    private boolean isNotValid(int row,int col,int val){

        int boxId = 3*(row/3) + (col/3);

        return rows[row].contains(val) || cols[col].contains(val) || boxes[boxId].contains(val);
    }
}
