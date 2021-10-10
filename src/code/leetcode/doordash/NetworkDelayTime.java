package code.leetcode.doordash;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//743. Network Delay Time
//https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue/
/**
 * Time Complexity: O(N^2 + E)O(N
 * 2
 *  +E)m where EE is the length of times in the basic implementation, and O(E \log E)O(ElogE) in the heap implementation, as potentially every edge gets added to the heap.
 *
 * Space Complexity: O(N + E)O(N+E), the size of the graph (O(E)O(E)), plus the size of the other objects used (O(N)O(N)).
 */
public class NetworkDelayTime {

    public int networkDelayTime(int times[][], int n, int k){

        Map<Integer, Map<Integer,Integer>> map  = new HashMap<>();

        for(int time[]:times){
            map.putIfAbsent(time[0],new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));

        pq.add(new int[]{0, k});

        boolean visited[] = new boolean[n+1];
        int res=0;

        while(!pq.isEmpty()){
            int curr[] = pq.remove();
            int currDist = curr[0];
            int currNode  = curr[1];

            if(visited[currNode])
                continue;

            visited[currNode] = true;

            res = currDist;
            n--;

            if(map.containsKey(currNode)) {
                for (int next : map.get(currNode).keySet()) {
                    pq.add(new int[]{currDist + map.get(currNode).get(next), next});
                }
            }
        }

        return n==0 ? res : -1;
    }
}
