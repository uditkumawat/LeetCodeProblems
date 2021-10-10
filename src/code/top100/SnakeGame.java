package code.top100;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/design-snake-game/discuss/521742/JAVA-simple-solution-easy-to-understand
public class SnakeGame {

    int r;
    int c;
    int rows;
    int cols;
    int index;
    int score;
    int foods[][];
    Queue<int[]> snake;

    public SnakeGame(int width,int height,int food[][]){
        r=0;
        c=0;
        index=0;
        score=0;
        rows = height;
        cols = width;
        foods = food;
        snake = new LinkedList<>();
    }

    public boolean isValidMove(int r,int c){
        return r>=0 && c>=0 && r<rows && c<cols;
    }

    public int move(String direction){
        switch(direction){
            case "U":
                r--;
                break;
            case "D":
                r++;
                break;
            case "L":
                c--;
                break;
            case "R":
                c++;
                break;
        }
        if(!isValidMove(r,c)){
            return -1;
        }
        else{
            return processAhead(r,c);
        }
    }

    public int processAhead(int r,int c){
        if(index==foods.length){
            snake.poll();
        }else if(r==foods[index][0] && c==foods[index][1]){
            index++;
            score++;
        }
        else{
            snake.poll();
        }

        for(int s[]:snake){
            if(r==s[0] && c==s[1]){
                return -1;
            }
        }

        snake.add(new int[]{r,c});
        return score;

    }
}
