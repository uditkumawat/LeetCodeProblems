package code.leetcode.studyplan75;

import java.util.*;

//https://www.youtube.com/watch?v=WhuiqhMXhxM
public class BuRoutes {

    public int numBusesToDestination(int[][] routes, int source, int target) {

        Map<Integer,List<Integer>> map = new HashMap();

        for(int i=0;i<routes.length;i++){
            for(int j=0;j<routes[i].length;j++){

                int busStopNo = routes[i][j];
                List<Integer> busNo = map.getOrDefault(busStopNo,new ArrayList());
                busNo.add(i);
                map.put(busStopNo,busNo);
            }
        }

        Queue<Integer> q = new LinkedList();
        Set<Integer> busStopVisited = new HashSet();
        Set<Integer> busVisited = new HashSet();
        int level = 0;

        q.add(source);
        busStopVisited.add(source);

        while(!q.isEmpty()){
            int size = q.size();

            while(size-->0){

                int rem = q.remove();
                if(rem==target){
                    return level;
                }

                List<Integer> buses = map.get(rem);
                for(int bus:buses){
                    if(busVisited.contains(bus)){
                        continue;
                    }
                    int arr[] = routes[bus];
                    for(int busStop:arr){
                        if(busStopVisited.contains(busStop)){
                            continue;
                        }
                        q.add(busStop);
                        busStopVisited.add(busStop);
                    }
                    busVisited.add(bus);
                }
            }
            level++;
        }

        return -1;
    }
}
