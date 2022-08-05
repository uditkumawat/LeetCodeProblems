package code.bloomberg;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/problems/design-a-leaderboard/solution/

/**
 * Time Complexity:
 *
 * O(O(logN) for addScore. This is because each addition to the BST takes a logarithmic time for search. The addition itself once the location of the parent is known, takes constant time.
 * O(O(logN) for reset since we need to search for the score in the BST and then update/remove it. Note that this complexity is in the case when every player always maintains a unique score.
 * It takes O(K) for our top function since we simply iterate over the keys of the TreeMap and stop once we're done considering K scores. Note that if the data structure doesn't provide a natural iterator, then we can simply get a list of all the key-value pairs and they will naturally be sorted due to the nature of this data structure. In that case, the complexity would be O(N)O(N) since we would be forming a new list.
 *
 * Space Complexity:
 *
 * O(N) used by the scores dictionary. Also, if you obtain all the key-value pairs in a new list in the top function, then an additional O(N)O(N) would be used.
 */
public class DesignLeaderBoardOptimized {

    public Map<Integer,Integer> scores;
    public TreeMap<Integer,Integer> sortedScores;

    public DesignLeaderBoardOptimized() {
        scores = new HashMap();
        sortedScores = new TreeMap<>(Collections.reverseOrder());
    }

    public void addScore(int playerId, int score) {

        if(!scores.containsKey(playerId)){
            scores.put(playerId,score);
            sortedScores.put(score,sortedScores.getOrDefault(score,0)+1);
        }
        else{

            int prevScore = scores.get(playerId);
            int playerCount = sortedScores.get(prevScore);

            if(playerCount==1){
                sortedScores.remove(prevScore);
            }
            else{
                sortedScores.put(prevScore,playerCount-1);
            }

            int newScore = prevScore+score;
            scores.put(playerId,newScore);
            sortedScores.put(newScore,sortedScores.getOrDefault(newScore,0)+1);
        }
    }

    public int top(int K) {

        int count = 0;
        int sum = 0;

        for(Map.Entry<Integer,Integer> entry:sortedScores.entrySet()){

            int times = entry.getValue();
            int key = entry.getKey();

            for(int i=0;i<times;i++){
                sum = sum + key;
                count++;

                if(count==K){
                    break;
                }
            }

            if(count==K){
                break;
            }
        }

        return sum;
    }

    public void reset(int playerId) {
        int prevScore = scores.get(playerId);
        sortedScores.put(prevScore,sortedScores.get(prevScore)-1);
        if(sortedScores.get(prevScore)==0){
            sortedScores.remove(prevScore);
        }
        scores.remove(playerId);
    }
}
