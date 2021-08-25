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

    }
    public boolean isValidSudoku(char[][] board) {

        int n = 9;

        if(board==null || board.length==0){
            return false;
        }

        Set<Character> rows[] = new HashSet[n];
        Set<Character> cols[] = new HashSet[n];
        Set<Character> boxes[] = new HashSet[n];

        for(int i=0;i<n;i++){
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
            boxes[i] = new HashSet<Character>();
        }

        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[r].length;c++){

                char k = board[r][c];

                if(k!='.'){

                    if(rows[r].contains(k)){
                        return false;
                    }

                    rows[r].add(k);

                    if(cols[c].contains(k)){
                        return false;
                    }

                    cols[c].add(k);

                    int boxIndex = (r/3)*3+c/3;

                    if(boxes[boxIndex].contains(k)){
                        return false;
                    }

                    boxes[boxIndex].add(k);
                }
            }
        }

        return true;
    }
}
