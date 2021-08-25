package code.top100;

/**
 * Time Complexity: O(1)O(1) because for every move, we mark a particular row, column, diagonal, and anti-diagonal in constant time.
 *
 * Space Complexity: O(n)O(n) because we use arrays rows and cols of size n. The variables diagonal and antiDiagonal use constant extra space.
 */
public class TicTacToe {

        private int rows[];
        private int cols[];
        private int diagnol;
        private int antiDiagnol;
        private int n;

        /** Initialize your data structure here. */
        public TicTacToe(int n) {
            this.n = n;
            rows = new int[n];
            cols = new int[n];
        }

        /** Player {player} makes a move at ({row}, {col}).
         @param row The row of the board.
         @param col The column of the board.
         @param player The player, can be either 1 or 2.
         @return The current winning condition, can be either:
         0: No one wins.
         1: Player 1 wins.
         2: Player 2 wins. */
        public int move(int row, int col, int player) {
            int currentPlayer = (player==1)?1:-1;
            rows[row] = rows[row]+currentPlayer;
            cols[col] = cols[col]+currentPlayer;
            if(row==col){
                diagnol = diagnol+currentPlayer;
            }
            if(row==n-col-1){
                antiDiagnol = antiDiagnol+currentPlayer;
            }

            if(Math.abs(rows[row])==n || Math.abs(cols[col])==n || Math.abs(diagnol)==n || Math.abs(antiDiagnol)==n){
                return player;
            }
            return 0;
        }

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
}
