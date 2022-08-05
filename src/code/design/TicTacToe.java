package code.design;

public class TicTacToe {

    int rows[];
    int cols[];
    int diagonalSum;
    int antiDiagonalSum;
    int n;
    public TicTacToe(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n];
        diagonalSum = 0;
        antiDiagonalSum = 0;
    }

    public int move(int row, int col, int player) {
        int currentPlayer = (player==1) ? -1:1;

        rows[row] = rows[row] + currentPlayer;
        cols[col] = cols[col] + currentPlayer;

        //only update the diagonal if row and col are equal
        if(row==col){
            diagonalSum = diagonalSum + currentPlayer;
        }

        //antidiagonal case
        if(row==n-col-1){
            antiDiagonalSum = antiDiagonalSum + currentPlayer;
        }

        if(n==Math.abs(rows[row]) || n==Math.abs(cols[col])
                || n==Math.abs(diagonalSum) || n==Math.abs(antiDiagonalSum)){
            return currentPlayer;
        }
        else{
            return 0;
        }
    }
}
