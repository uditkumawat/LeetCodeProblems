package code.explorecard.recursion;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {

    public static void main(String args[]){

        char board[][] = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

        SudokuSolver obj = new SudokuSolver();

        obj.solveSudoku(board);

        obj.printBoard(board);
        
    }

    public void printBoard(char board[][]){

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void solveSudoku(char[][] board) {
        int n = board.length;

        Set<Character> rowsSet[] = new HashSet[n*n];
        Set<Character> colsSet[] = new HashSet[n*n];
        Set<Character> boxSet[] = new HashSet[n*n];

        for(int i=0;i<n*n;i++){
            rowsSet[i] = new HashSet<Character>();
            colsSet[i] = new HashSet<Character>();
            boxSet[i] = new HashSet<Character>();
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]!='.') {
                    rowsSet[i].add(board[i][j]);
                    colsSet[j].add(board[i][j]);
                    boxSet[3*(i/3)+j/3].add(board[i][j]);
                }
            }
        }

        solveUtil(board,n,rowsSet,colsSet,boxSet);
    }

    public boolean solveUtil(char board[][],int n, Set<Character> rowsSet[], Set<Character> colsSet[], Set<Character> boxSet[]){

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='.'){

                    for(char k='1';k<='9';k++){

                        if(isSafePlaceToInsertValue(board,i,j,k,rowsSet,colsSet,boxSet)){

                            board[i][j] = k;

                            rowsSet[i].add(k);
                            colsSet[j].add(k);
                            boxSet[3*(i/3)+j/3].add(k);


                            if(solveUtil(board,n,rowsSet,colsSet,boxSet)){
                                return true;
                            }

                            rowsSet[i].remove(k);
                            colsSet[j].remove(k);
                            boxSet[3*(i/3)+j/3].remove(k);

                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isSafePlaceToInsertValue(char board[][],int row,int col,char value, Set<Character> rowsSet[], Set<Character> colsSet[], Set<Character> boxSet[]){

        if(rowsSet[row].contains(value) || colsSet[col].contains(value) || boxSet[3*(row/3)+col/3].contains(value)){
            return false;
        }
        return true;
    }
}
