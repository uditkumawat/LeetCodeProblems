package code.top100;

/**
 * Time complexity is constant here since the board size is fixed and there is no N-parameter to measure. Though let's discuss the number of operations needed : (9!)^9(9!)
 * 9
 *  . Let's consider one row, i.e. not more than 99 cells to fill. There are not more than 99 possibilities for the first number to put, not more than 9 \times 89×8 for the second one, not more than 9 \times 8 \times 79×8×7 for the third one etc. In total that results in not more than 9!9! possibilities for a just one row, that means not more than (9!)^9(9!)
 * 9
 *   operations in total. Let's compare:
 *
 * 9^{81} = 1966270504755529136180759085269121162831034509442147669273154155379663911968099
 * 81
 *  =196627050475552913618075908526912116283103450944214766927315415537966391196809 for the brute force,
 *
 * and (9!)^9 = 109110688415571316480344899355894085582848000000000(9!)
 * 9
 *  =109110688415571316480344899355894085582848000000000 for the standard backtracking, i.e. the number of operations is reduced in 10^{27}10
 * 27
 *   times !
 *
 * Space complexity : the board size is fixed, and the space is used to store board, rows, columns and boxes structures, each contains 81 elements.
 */
public class SudokoSolver {

    public static void main(String args[]){
        char board[][]={{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        solveSudoku(board);
    }
        public static void solveSudoku(char[][] board) {
            if(board==null || board.length==0)
            {
                return;
            }
            solve(board);

            //printing after it is done
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
            return;
        }

        public static boolean solve(char board[][]){

            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    if(board[i][j]=='.'){
                        for(char k='1';k<='9';k++){
                            if(isValid(board,i,j,k)){

                                board[i][j] = k;

                                if(solve(board)){
                                    return true; ////If it's the solution return true
                                }
                                else{
                                    board[i][j] = '.';
                                }
                            }
                        }
                        return false;
                    }
                }
            }

            return true;
        }

        public static boolean isValid(char board[][],int row,int col,char c){

            for(int i=0;i<9;i++){
                if(board[row][i]==c){
                    return false;
                }
                if(board[i][col]==c){
                    return false;
                }
            }

            /**
             * //getting the top left corner of 3 cross 3 matrix
             *         //row/3 & col/3 gives u exact subarray box , we multiply these by 3
             *         //so that we can get the top left corner of that box(i.e box starting)
             */
            int startingRowIndexBox = (row/3)*3;
            int startingColIndexBox = (col/3)*3;

            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(board[startingRowIndexBox+i][startingColIndexBox+j]==c){
                        return false;
                    }
                }
            }

            return true;
        }
}
