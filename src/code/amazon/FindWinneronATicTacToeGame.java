package code.amazon;

//https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/solution/
//TC - O(m)
//SC - O(N)
public class FindWinneronATicTacToeGame {

    public static void main(String args[]){

        int moves[][] = {{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}};

        FindWinneronATicTacToeGame obj = new FindWinneronATicTacToeGame();

        System.out.println(obj.tictactoe(moves));
    }
    public String tictactoe(int[][] moves) {

        int rows[] = new int[3];
        int cols[] = new int[3];
        int diagonal = 0;
        int antidiagonal = 0;

        boolean first = true;

        for(int move[]:moves){

            int row = move[0];
            int col = move[1];

            rows[row] = rows[row] + (first?1:-1);
            cols[col] = cols[col] + (first?1:-1);

            if(row==col){
                diagonal = diagonal + (first?1:-1);
            }
            if(row==3-col-1){
                antidiagonal = antidiagonal + (first?1:-1);
            }

            if(rows[row]==3 || cols[col]==3 || diagonal==3 || antidiagonal==3){
                return "A";
            }
            else if(rows[row]==-3 || cols[col]==-3 || diagonal==-3 || antidiagonal==-3){
                return "B";
            }

            first = !first;
        }

        return "Draw";

    }
}
