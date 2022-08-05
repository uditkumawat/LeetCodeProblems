package code.bloomberg;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/design-a-leaderboard/submissions/
//TC - O(nlogk) -> n times logk for heap
//SC - O(n+k) -> n is used for players map and k for heap
public class DesignALeaderBoard {

    Map<Integer,Integer> players;
    PriorityQueue<Map.Entry<Integer,Integer>> pq;
    public DesignALeaderBoard() {
        players = new HashMap();
        pq = new PriorityQueue<Map.Entry<Integer,Integer>>((Map.Entry<Integer,Integer> e1, Map.Entry<Integer,Integer> e2)->{
            return e1.getValue()-e2.getValue();
        });
    }

    public void addScore(int playerId, int score) {
        if(!players.containsKey(playerId)){
            players.put(playerId,score);
        }
        else{
            int prevScore = players.get(playerId);
            players.put(playerId,score+prevScore);
        }
    }

    public int top(int K) {

        int sum = 0;

        for(Map.Entry<Integer,Integer> entry:players.entrySet()){
            pq.add(entry);
            if(pq.size()>K){
                pq.poll();
            }
        }

        while(!pq.isEmpty()){
            sum = sum + pq.poll().getValue();
        }

        return sum;
    }

    public void reset(int playerId) {
        players.put(playerId,0);
    }
}
