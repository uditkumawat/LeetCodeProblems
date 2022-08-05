
package code.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/time-needed-to-inform-all-employees/
public class TimeNeededToInformAllEmployees {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<manager.length;i++){

            int empM = manager[i];

            map.putIfAbsent(empM,new ArrayList<>());
            map.get(empM).add(i);
        }

        return dfs(headID,map,informTime,n);
    }

    public int dfs(int headId,Map<Integer,List<Integer>> map,int informTime[],int n){

        int ans = 0;
        if(map.containsKey(headId)){
            for(int neighbour:map.get(headId)){
                ans = Math.max(ans,dfs(neighbour,map,informTime,n));
            }
        }
        return ans+informTime[headId];
    }
}
