package code.amazon;

//https://leetcode.com/problems/design-tic-tac-toe/

/**
 * Time Complexity: O(1)O(1) because for every move, we mark a particular row, column, diagonal, and anti-diagonal in constant time.
 *
 * Space Complexity: O(n)O(n) because we use arrays rows and cols of size n. The variables diagonal and antiDiagonal use constant extra space.
 */
public class DesignTicTacToe {

    int n;
    int rows[];
    int cols[];
    int diagonal;
    int antiDiagonal;
    public DesignTicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        this.n = n;
        diagonal = 0;
        antiDiagonal = 0;
    }

    public int move(int row, int col, int player) {
        int val = 0;
        if(player==1){
            val = 1;
        }
        else{
            val = -1;
        }

        rows[row] = rows[row] + val;
        cols[col] = cols[col] + val;

        if(row==col){
            diagonal+=val;
        }

        if(n==(row+col+1)){
            antiDiagonal+=val;
        }

        if(hasWon(row,col)){
            return player;
        }

        return 0;
    }

    private boolean hasWon(int row,int col){

        return Math.abs(rows[row])==n || Math.abs(cols[col])==n || Math.abs(diagonal)==n || Math.abs(antiDiagonal)==n;

    }
}
