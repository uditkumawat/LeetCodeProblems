package code.salesforce;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/snakes-and-ladders/submissions/
//https://www.geeksforgeeks.org/snake-ladder-problem-2/
//TC - O(N)
//SC - O(N)
public class SnakesAndLadders {

    class QueueEntry{
        int entry;
        int moves;
        QueueEntry(int entry,int moves){
            this.entry = entry;
            this.moves = moves;
        }
    }

    public int snakesAndLadders(int[][] board) {

        int N = board.length;
        if(N==0){
            return 0;
        }

        int totalSquares = N*N;

        int values[] = new int[totalSquares+1];

        convertTo1DArray(board,values);

        boolean visited[] = new boolean[totalSquares+1];

        Queue<QueueEntry> q = new LinkedList();
        QueueEntry qe = new QueueEntry(1,0);

        q.add(qe);

        visited[1] = true;

        while(!q.isEmpty()){

            qe = q.poll();

            if(qe.entry==totalSquares){
                break;
            }

            for(int i=qe.entry+1;i<=Math.min(qe.entry+6,totalSquares);i++){

                int newEntry = 0;
                if(!visited[i]){
                    if(values[i]!=-1){
                        newEntry = values[i];
                    }else{
                        newEntry = i;
                    }
                    q.add(new QueueEntry(newEntry,qe.moves+1));
                    visited[i] = true;
                }
            }
        }
        if(qe.entry!=totalSquares){
            return -1;
        }
        return qe.moves;
    }

    public void convertTo1DArray(int board[][],int values[]){

        int index = 1;
        boolean leftToRight = true;

        for(int row=board.length-1;row>=0;row--){
            if(leftToRight){
                for(int col=0;col<board[0].length;col++){
                    values[index++] = board[row][col];
                }
            }
            else{
                for(int col=board[0].length-1;col>=0;col--){
                    values[index++] = board[row][col];
                }
            }
            leftToRight = !leftToRight;
        }
    }
}
