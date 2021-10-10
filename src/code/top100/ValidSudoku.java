package code.top100;

import java.util.HashSet;
import java.util.Set;

/**
 * Let NN be the board length, which is 9 in this question. Note that since the value of NN is fixed, the time and space complexity of this algorithm can be interpreted as O(1)O(1). However, to better compare each of the presented approaches, we will treat NN as an arbitrary value in the complexity analysis below.
 *
 * Time complexity: O(N^2)O(N
 * 2
 *  ) because we need to traverse every position in the board, and each of the four check steps is an O(1)O(1) operation.
 *
 * Space complexity: O(N^2)O(N
 * 2
 *  ) because in the worst-case scenario, if the board is full, we need a hash set each with size N to store all seen numbers for each of the N rows, N columns, and N boxes, respectively.
 */
public class ValidSudoku {

    public static void main(String args[]){
            
        char board[][] = {{'5','3','.','.','7','.','.','.','.'}
                        ,{'6','.','.','1','9','5','.','.','.'}
                        ,{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'}
                        ,{'4','.','.','8','.','3','.','.','1'}
                        ,{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'}
                        ,{'.','.','.','4','1','9','.','.','5'}
                        ,{'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {

        int n = board.length;
        int rows = board.length;
        int cols = board[0].length;

        Set<Character> rowsHash[] = new HashSet[n];
        Set<Character> colsHash[] = new HashSet[n];
        Set<Character> boxesHash[] = new HashSet[n];

        for(int i=0;i<n;i++){
            rowsHash[i] = new HashSet<Character>();
            colsHash[i] = new HashSet<Character>();
            boxesHash[i] = new HashSet<Character>();
        }

        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){

                char c = board[row][col];
                if(c!='.'){
                    if(rowsHash[row].contains(c)){
                        return false;
                    }
                    rowsHash[row].add(c);

                    if(colsHash[col].contains(c)){
                        return false;
                    }
                    colsHash[col].add(c);

                    int boxIndex = (row/3)*3+col/3;
                    if(boxesHash[boxIndex].contains(c)){
                        return false;
                    }
                    boxesHash[boxIndex].add(c);
                }
            }
        }
        return true;
    }
}
