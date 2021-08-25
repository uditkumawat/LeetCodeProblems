package code.top100;

/**
 * Time Complexity: \mathcal{O}(N)O(N) where NN is the number of cells in the board. In the worst case where it contains only the O cells on the board, we would traverse each cell twice: once during the DFS traversal and the other time during the cell reversion in the last step.
 *
 * Space Complexity: \mathcal{O}(N)O(N) where NN is the number of cells in the board. There are mainly two places that we consume some additional memory.
 *
 * We keep a list of border cells as starting points for our traversal. We could consider the number of border cells is proportional to the total number (NN) of cells.
 *
 * During the recursive calls of DFS() function, we would consume some space in the function call stack, i.e. the call stack will pile up along with the depth of recursive calls. And the maximum depth of recursive calls would be NN as in the worst scenario mentioned in the time complexity.
 *
 * As a result, the overall space complexity of the algorithm is \mathcal{O}(N)O(N).
 */
public class SurroundedRegions {

    public static void main(String args[]){
        
        char board[][] = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};

        solve(board);

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void solve(char[][] board) {

        if(board==null || board.length==0){
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        for(int i=0;i<cols;i++){
            dfs(board,0,i,rows,cols);
            dfs(board,rows-1,i,rows,cols);
        }

        for(int i=0;i<rows;i++){
            dfs(board,i,0,rows,cols);
            dfs(board,i,cols-1,rows,cols);
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]=='1'){
                    board[i][j] = 'O';
                }
                else if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void dfs(char board[][],int row,int col,int rows,int cols){
        if(row<0 || cols<0 || row>=rows || col>=cols || board[row][col]!='O'){
            return;
        }

        board[row][col] = '1';

        dfs(board,row,col-1,rows,cols);
        dfs(board,row-1,col,rows,cols);
        dfs(board,row,col+1,rows,cols);
        dfs(board,row+1,col,rows,cols);

    }
}
