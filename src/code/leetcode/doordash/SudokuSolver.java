package code.leetcode.doordash;

//TC - O(9^81)
public class SudokuSolver {

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

        boolean ans = solveSudoku(board);
        if(ans==false){
            System.out.println("Not possible");
        }
        else {
            //printing after it is done
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static boolean solveSudoku(char board[][]){
        if(board==null || board.length==0){
            return false;
        }
        int rows = board.length;
        int cols = board[0].length;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]=='.'){

                    for(char c='1';c<='9';c++){

                        if(isValid(board,i,j,c)){
                            board[i][j] = c;

                            if(solveSudoku(board)){
                                return true;
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

        int rows = board.length;
        int cols = board[0].length;
        //check for row
        for(int i=0;i<cols;i++){
            if(board[row][i]==c){
                return false;
            }
        }

        //check for col
        for(int i=0;i<rows;i++){
            if(board[i][col]==c){
                return false;
            }
        }

        //getting the top left corner of 3 cross 3 matrix
        //row/3 & col/3 gives u exact subarray box , we multiply these by 3
        //so that we can get the top left corner of that box(i.e box starting)

        //check for box

        int boxR = (row/3)*3;
        int boxC = (col/3)*3;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i+boxR][j+boxC]==c){
                    return false;
                }
            }
        }

        return true;
    }
}
