package code.june.challenge;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=GHbEzmkA8YM
//Tc - O(n!)

/**
 * Space complexity: O(N^2)O(N
 * 2
 *  )
 *
 * Extra memory used includes the 3 sets used to store board state, as well as the recursion call stack. All of this scales linearly with the number of queens. However, to keep the board state costs O(N^2)O(N
 * 2
 *  ), since the board is of size N * N. Space used for the output does not count towards space complexity.
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {

        char board[][] = new char[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }

        List<List<String>> res = new ArrayList();

        fillBoard(board,0,n,res);

        return res;
    }

    public void fillBoard(char board[][],int row,int n,List<List<String>> res){

        if(row==n){
            List<String> temp = new ArrayList<>();
            for(int i=0;i<board.length;i++){
                String s = new String(board[i]);
                temp.add(s);
            }
            res.add(temp);
            return;
        }

        for(int col=0;col<n;col++){

            if(isValid(board,row,col,n)){

                board[row][col] = 'Q';

                fillBoard(board,row+1,n,res);

                board[row][col] = '.';
            }
        }
    }

    private boolean isValid(char board[][],int row,int col,int n){

        //leftDiagonal
        int r = row-1;
        int c = col-1;

        while(r>=0 && c>=0){
            if(board[r][c]=='Q'){
                return false;
            }
            r--;
            c--;
        }

        //right diagonal
        r = row-1;
        c = col+1;

        while(r>=0 && c<n){
            if(board[r][c]=='Q'){
                return false;
            }
            r--;
            c++;
        }

        //same column
        r = row-1;
        c = col;
        while(r>=0){
            if(board[r][c]=='Q'){
                return false;
            }
            r--;
        }
        return true;
    }
}
