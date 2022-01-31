package code.airbnb;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
On an 2 x 3 board, there are five tiles labeled from 1 to 5, and an empty square represented by 0. A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.

The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].

Given the puzzle board board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return -1.

time, O(6 * 6!) - there are only 6! possible situations
space, O(n) - since we used a queue

 */
public class SlidingPuzzle {

    public static void main(String args[]){

        int board[][]={{4,1,2},{5,0,3}};

        SlidingPuzzle obj = new SlidingPuzzle();
        System.out.println(obj.getMinMoves(board));
    }

    public int getMinMoves(int board[][]){

        String target = "123450";
        int moves = 0;
        String start = "";

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                start+=board[i][j];
            }
        }

        HashSet<String> visited = new HashSet<>();

        //when zero is in position:0 it can go to cell {1,3}, position:1 it can go {0,2,4} and so on, also when i mean position i'm talking about the index of zero in the string not the input array.
        int dirs[][] = new int[][]{{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};

        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String curr = queue.poll();
                if(curr.equals(target)){
                    return moves;
                }

                int zeroIndex = curr.indexOf("0");
                for(int dir:dirs[zeroIndex]){
                    String next = swap(curr,zeroIndex,dir);
                    if(visited.contains(next)){
                        continue;
                    }
                    visited.add(next);
                    queue.add(next);
                }
            }
            moves++;
        }

        return -1;
    }

    private String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}
