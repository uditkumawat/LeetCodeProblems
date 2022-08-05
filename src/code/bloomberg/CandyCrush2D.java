package code.bloomberg;

//https://leetcode.com/problems/candy-crush/solution/
//TC - O((r*c)^2)
public class CandyCrush2D {

    public int[][] candyCrush(int[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        boolean todo = false;

        //checking horizontally
        for(int r=0;r<rows;r++){
            for(int c=0;c+2<cols;c++){

                int v = Math.abs(board[r][c]);

                if(v!=0 && v==Math.abs(board[r][c+1]) && v==Math.abs(board[r][c+2])){

                    board[r][c] = board[r][c+1] = board[r][c+2] = -v;
                    todo = true;
                }
            }
        }

        //checking vertically
        for(int r=0;r+2<rows;r++){
            for(int c=0;c<cols;c++){

                int v = Math.abs(board[r][c]);

                if(v!=0 && v==Math.abs(board[r+1][c]) && v==Math.abs(board[r+2][c])){

                    board[r][c] = board[r+1][c] = board[r+2][c] = -v;
                    todo = true;
                }
            }
        }

        for(int c=0;c<cols;c++){
            int wr = rows-1;
            for(int r=rows-1;r>=0;r--){
                if(board[r][c]>0){
                    board[wr--][c] = board[r][c];
                }
            }

            while(wr>=0){
                board[wr--][c]=0;
            }
        }

        return todo?candyCrush(board):board;
    }
}
