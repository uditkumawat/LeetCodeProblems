package code.salesforce;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/sudoku-solver/submissions/
//TC - O(9^m) -> m is the number of empty cells on board, each cell can be filled with 9 different digits
public class SudukoSolver {

    public void solveSudoku(char[][] board) {

        if(board==null || board.length==0){
            return;
        }

        int n = board.length;

        Set<Character> rows[] = new HashSet[n];
        Set<Character> cols[] = new HashSet[n];
        Set<Character> boxes[] = new HashSet[n];

        for(int i=0;i<n;i++){
            rows[i] = new HashSet();
            cols[i] = new HashSet();
            boxes[i] = new HashSet();
        }
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){

                char c = board[row][col];

                if(c!='.'){
                    rows[row].add(c);
                    cols[col].add(c);
                    int boxId = getBoxId(row,col);
                    boxes[boxId].add(c);
                }
            }
        }

        //filling it row by row
        solve(board,rows,cols,boxes,0,0);
    }

    public boolean solve(char board[][],Set<Character> rows[],Set<Character> cols[],Set<Character> boxes[],int row,int col){

        if(col==9){
            row++;
            col = 0;
        }

        if(row==9){
            return true;
        }


        if(board[row][col]=='.'){

            for(char num='1';num<='9';num++){

                if(isValid(board,rows,cols,boxes,row,col,num)){
                    board[row][col] = num;
                    rows[row].add(num);
                    cols[col].add(num);
                    boxes[3*(row/3)+(col/3)].add(num);

                    if(solve(board,rows,cols,boxes,row,col+1)){
                        return true;
                    }

                    board[row][col] = '.';
                    rows[row].remove(num);
                    cols[col].remove(num);
                    boxes[3*(row/3)+(col/3)].remove(num);
                }
            }
        }
        else{
            return solve(board,rows,cols,boxes,row,col+1);
        }

        return false;

    }

    public boolean isValid(char board[][],Set<Character> rows[],Set<Character> cols[],Set<Character> boxes[],int row,int col,char c){

        int boxId = 3*(row/3) + (col/3);

        if(rows[row].contains(c) || cols[col].contains(c) || boxes[boxId].contains(c)){
            return false;
        }
        return true;
    }

    private int getBoxId(int row,int col){
        return 3*(row/3)+(col/3);
    }
}
