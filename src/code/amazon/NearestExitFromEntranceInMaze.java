package code.amazon;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {

    public static void main(String args[]){

        char maze[][] = {{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
        int entrance[] = new int[]{1,2};

        NearestExitFromEntranceInMaze obj = new NearestExitFromEntranceInMaze();

        System.out.println(obj.nearestExit(maze,entrance));

    }
    public int nearestExit(char[][] maze, int[] entrance) {

        int rows = maze.length;
        int cols = maze[0].length;
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        boolean visited[][] = new boolean[rows][cols];

        q.add(new Pair(entrance[0],entrance[1]));
        visited[entrance[0]][entrance[1]] = true;
        int steps = 0;

        int dirs[][] = {{1,0},{0,1},{-1,0},{0,-1}};

        while(!q.isEmpty()){

            int s = q.size();

            while(s-->0) {
                Pair<Integer, Integer> coordinate = q.poll();

                int x = coordinate.getKey();
                int y = coordinate.getValue();

                if (x == 0 || y == 0 || x == rows - 1 || y == cols - 1) {
                    return steps;
                }

                for (int i = 0; i < dirs.length; i++) {

                    int newX = x + dirs[i][0];
                    int newY = y + dirs[i][1];

                    if (isValid(maze, newX, newY, rows, cols, entrance, visited)) {

                        q.add(new Pair(newX, newY));
                        visited[newX][newY] = true;
                    }
                }
            }

            steps++;
        }

        return steps;
    }

    boolean isValid(char maze[][],int row,int col,int rows,int cols,int entrance[],boolean visited[][]){

        if(row<0 || row>=rows || col<0 || col>=cols || (entrance[0]==row && entrance[1]==col) ||
                maze[row][col]!='+' || visited[row][col]){
            return false;
        }
        return true;
    }
}
