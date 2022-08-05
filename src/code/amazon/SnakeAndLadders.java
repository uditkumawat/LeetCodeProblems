package code.amazon;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//https://www.youtube.com/watch?v=OutDY_ICb80
//https://leetcode.com/problems/snakes-and-ladders/
public class SnakeAndLadders {

    public static void main(String args[]){

        int board[][] = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};

        SnakeAndLadders obj = new SnakeAndLadders();

        System.out.println(obj.snakesAndLadders(board));

    }
    public int snakesAndLadders(int[][] board) {

        int n = board.length;

        int arr[] = new int[n*n];

        int rows = board.length;
        int cols = board[0].length;

        boolean leftToRight = true;

        int k = 0;
        for(int i=rows-1;i>=0;i--) {
            for (int j = 0; j < cols; j++) {
                if(leftToRight){
                    arr[k++] = board[i][j];
                }
                else{
                    arr[k++] = board[i][cols-1-j];
                }
            }
            leftToRight = !leftToRight;
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        int steps = 0;

        while(!q.isEmpty()){
            int size = q.size();
            steps++;
            while(size-->0){
                int index = q.poll();
                if(index==n*n-1){
                    return steps;
                }
                for(int i=1;i<=6;i++){
                    int nextSquareIndex = i+index;
                    if(arr[nextSquareIndex]!=-1){
                        nextSquareIndex = arr[nextSquareIndex];
                    }
                    if(!visited.contains(nextSquareIndex)) {
                        q.add(nextSquareIndex);
                        visited.add(nextSquareIndex);
                    }
                }
            }
        }

        return -1;
    }
}
