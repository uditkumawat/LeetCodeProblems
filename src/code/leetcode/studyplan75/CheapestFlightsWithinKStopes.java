package code.leetcode.studyplan75;

import java.util.*;

//https://www.youtube.com/watch?v=71xQSBWUupU&t=1259s
//https://leetcode.com/problems/cheapest-flights-within-k-stops/
public class CheapestFlightsWithinKStopes {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<int[]>> map = new HashMap();

        for(int fl[]:flights){
            map.putIfAbsent(fl[0],new ArrayList());
            map.get(fl[0]).add(new int[]{fl[1],fl[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((int e1[], int e2[])->{
            return e1[1]-e2[1];
        });

        pq.add(new int[]{src,0,k});

        while(!pq.isEmpty()){

            int arr[] = pq.poll();

            int currNode = arr[0];
            int cost = arr[1];
            int kk = arr[2];

            if(currNode==dst){
                return cost;
            }

            if(kk>=0){
                if(map.containsKey(currNode)){
                    for(int fl[]:map.get(currNode)){
                        pq.add(new int[]{fl[0],cost+fl[1],kk-1});
                    }
                }
            }
        }

        return -1;
    }
}
