package code.graph;

import javafx.util.Pair;

import java.util.*;

//https://leetcode.com/problems/network-delay-time/solution/
public class NetworkDelayTime {

    Map<Integer, List<Pair<Integer,Integer>>> adj = new HashMap<>();

    public int networkDelayTime(int[][] times, int n, int k) {

        for(int time[]:times){
            int source = time[0];
            int dest = time[1];
            int traveltime = time[2];

            adj.putIfAbsent(source,new ArrayList<>());
            adj.get(source).add(new Pair(traveltime,dest));
        }

        int signalReceivedAt[] = new int[n+1];

        Arrays.fill(signalReceivedAt,Integer.MAX_VALUE);

        dijkstra(signalReceivedAt,k,n);

        int ans = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            ans = Math.max(ans,signalReceivedAt[i]);
        }

        return ans==Integer.MAX_VALUE?-1:ans;
    }

    public void dijkstra(int signalReceivedAt[],int source,int n){

        Queue<Pair<Integer,Integer>> pq = new PriorityQueue<Pair<Integer,Integer>>((p1, p2)->{
            return p1.getKey()-p2.getKey();
        });

        pq.add(new Pair(0,source));

        signalReceivedAt[source] = 0;

        while(!pq.isEmpty()){

            Pair<Integer,Integer> pair = pq.remove();

            int currNodeTime = pair.getKey();
            int currNode = pair.getValue();

            if(currNodeTime>signalReceivedAt[currNode]){
                continue;
            }

            if(!adj.containsKey(currNode)){
                continue;
            }

            for(Pair<Integer,Integer> edge:adj.get(currNode)){
                int time = edge.getKey();
                int neighbour = edge.getValue();

                if(signalReceivedAt[neighbour]>currNodeTime+time){
                    signalReceivedAt[neighbour] = currNodeTime+time;
                    pq.add(new Pair(signalReceivedAt[neighbour],neighbour));
                }
            }
        }
    }
}
