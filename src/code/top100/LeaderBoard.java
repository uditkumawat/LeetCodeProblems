package code.top100;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeaderBoard {

    private HashMap<Integer,Integer> scores;
    LeaderBoard() {
        scores = new HashMap<>();
    }

    public static void main(String args[]){
        LeaderBoard obj = new LeaderBoard();
        obj.addScore(1,73);
        obj.addScore(2,56);
        obj.addScore(3,39);
        obj.addScore(4,51);
        obj.addScore(5,4);
        System.out.println(obj.top(1));
        obj.reset(1);
        obj.reset(2);
        obj.addScore(2,51);
        System.out.println(obj.top(3));
    }

    public void addScore(int playerId, int score) {
        scores.put(playerId,scores.getOrDefault(playerId,0)+score);
    }

    public int top(int K) {

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a, b)->a.getValue()-b.getValue());

        for(Map.Entry<Integer,Integer> entry:scores.entrySet()){
            pq.add(entry);
            if(pq.size()>K){
                pq.poll();
            }
        }

        int sum = 0;
        while(!pq.isEmpty()){
            sum+=pq.poll().getValue();
        }

        return sum;
    }

    public void reset(int playerId) {
        scores.remove(playerId,0);
    }
}
