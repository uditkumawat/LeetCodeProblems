package code.airbnb;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SlidingPuzzleActualQuestionFromInternet {

    // An 8-puzzle is an old game where we’re given a 3x3 board of tiles with the 9th tile missing.The tiles have a number on them 1 through 8,
// and each puzzle starts out shuffled. Tiles may slide into the empty space (horizontally or vertically), but no tile may be removed from the board.


// # Example state
// # +---+---+---+
// # | 1 | 2 | 3 |
// # +---+---+---+
// # | 8 |   | 5 |
// # +---+---+---+
// # | 4 | 7 | 6 |
// # +---+---+---+

// 3*3 -> 123805476

// # Another solvable starting state
// # +---+---+---+
// # | 3 | 1 | 2 |
// # +---+---+---+
// # |  | 4 | 5 |
// # +---+---+---+
// # | 6 | 7 | 8 |
// # +---+---+---+

// # An example for non-solvable state
// # +---+---+---+
// # | 8 | 1 | 2 |
// # +---+---+---+
// # |   | 4 | 3 |
// # +---+---+---+
// # | 7 | 6 | 5 |
// # +---+---+---+

// # End state:
// # +---+---+---+
// # | 1 | 2 | 3 |
// # +---+---+---+
// # | 4 | 5 | 6 |
// # +---+---+---+
// # | 7 | 8 |   |
// # +---+---+---+

// 123456780

// 1. Define this into a data structure
// 2. Given a state, whether it's solvable?

    static boolean  isSolvable(int board[][]) {

            StringBuilder sb = new StringBuilder();

            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[i].length;j++){
                    sb.append(board[i][j]);
                }
            }

            String startingString = sb.toString();

            int dirs[][] = {{1,3},{0,2,4},{1,5},{0,4,6},{1,3,5,7},{2,4,8},{3,7},{6,4,8},{5,7}};

            String targetString = "123456780";
            Queue<String> q = new LinkedList<>();
            Set<String> visited = new HashSet<>();

            q.add(startingString);

            while(!q.isEmpty()){
                int size = q.size();

                for(int i=0;i<size;i++){
                    String temp = q.poll();

                    if(temp.equals(targetString)){
                        return true;
                    }

                    int currentZeroIndex = temp.indexOf("0");

                    for(int dir:dirs[currentZeroIndex]){
                        String newString = swap(temp,dir,currentZeroIndex);

                        if(visited.contains(newString)){
                            continue;
                        }
                        visited.add(newString);
                        q.add(newString);

                    }
                }

            }

            return false;
        }

        public static String swap(String temp,int i, int j){
            StringBuilder sb = new StringBuilder(temp);
            sb.setCharAt(i,temp.charAt(j));
            sb.setCharAt(j,temp.charAt(i));
            return sb.toString();
        }

        public static void main(String args[] ) throws Exception {
            int board[][] = {{3,1,2},{0,4,5},{6,7,8}};
            System.out.println(isSolvable(board));
        }
    }
