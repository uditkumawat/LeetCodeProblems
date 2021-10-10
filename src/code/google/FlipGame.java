package code.google;

import java.util.ArrayList;
import java.util.List;

/**
 * You are playing a Flip Game with your friend.
 *
 * You are given a string currentState that contains only '+' and '-'. You and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move, and therefore the other person will be the winner.
 *
 * Return all possible states of the string currentState after one valid move. You may return the answer in any order. If there is no valid move, return an empty list [].
 */
public class FlipGame {

    public static void main(String args[]){

        FlipGame obj = new FlipGame();
        String currentState = "+-+---++++";
        List<String> res = obj.generatePossibleNextMoves(currentState);

        for(String str:res){
            System.out.println(str);
        }
    }

    public List<String> generatePossibleNextMoves(String currentState) {

        List<String> res = new ArrayList<>();
        if(currentState==null || currentState.length()<2){
            return res;
        }

        char str[] = currentState.toCharArray();
        for(int i=1;i<currentState.length();i=i+1){
            if(str[i-1]=='+' && str[i]=='+'){
                str[i-1] = '-';
                str[i] = '-';

                res.add(String.valueOf(str));

                str[i-1] = '+';
                str[i] = '+';

            }
        }

        return res;
    }
}
