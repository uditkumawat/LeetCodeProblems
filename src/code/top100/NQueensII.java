package code.top100;

import java.util.HashSet;
import java.util.Set;

///TC - O(N!)
//https://leetcode.com/problems/n-queens-ii/solution/
/**
 * Time complexity: O(N!)O(N!), where NN is the number of queens (which is the same as the width and height of the board).
 *
 * Unlike the brute force approach, we place a queen only on squares that aren't attacked. For the first queen, we have NN options. For the next queen, we won't attempt to place it in the same column as the first queen, and there must be at least one square attacked diagonally by the first queen as well. Thus, the maximum number of squares we can consider for the second queen is N - 2N−2. For the third queen, we won't attempt to place it in 2 columns already occupied by the first 2 queens, and there must be at least two squares attacked diagonally from the first 2 queens. Thus, the maximum number of squares we can consider for the third queen is N - 4N−4. This pattern continues, giving an approximate time complexity of N!N! at the end.
 *
 * Space complexity: O(N)O(N), where NN is the number of queens (which is the same as the width and height of the board).
 *
 * Extra memory used includes the 3 sets used to store board state, as well as the recursion call stack. All of this scales linearly with the number of queens.
 */
public class NQueensII {

    public static void main(String args[]) {

        int n = 2;
        System.out.println(backtrack(0,new HashSet<>(),new HashSet<>(),new HashSet<>(),n));
    }

    public static int backtrack(int row, Set<Integer> cols, Set<Integer> diagnols, Set<Integer> antiDiagnols,int size){
        if(row==size){
            return 1;
        }

        int solutions = 0;

        for(int col=0;col<size;col++){

            int diagnolNumber = row-col;
            int antiDiagnolNumber = row+col;

            if(cols.contains(col) || diagnols.contains(diagnolNumber) || antiDiagnols.contains(antiDiagnolNumber)){
                continue;
            }

            cols.add(col);
            diagnols.add(diagnolNumber);
            antiDiagnols.add(antiDiagnolNumber);

            solutions+=backtrack(row+1,cols,diagnols,antiDiagnols,size);

            cols.remove(col);
            diagnols.remove(diagnolNumber);
            antiDiagnols.remove(antiDiagnolNumber);
        }

        return solutions;
    }
}
