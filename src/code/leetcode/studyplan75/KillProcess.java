package code.leetcode.studyplan75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/kill-process/solution/
//TC - O(N)
//SC - O(N)
public class KillProcess {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

        Map<Integer,List<Integer>> map = new HashMap();

        for(int i=0;i<ppid.size();i++){

            if(ppid.get(i)>0){
                List<Integer> list = map.getOrDefault(ppid.get(i),new ArrayList<Integer>());
                list.add(pid.get(i));

                map.put(ppid.get(i),list);
            }
        }

        List<Integer> res = new ArrayList();
        res.add(kill);
        dfs(map,res,kill);

        return res;
    }

    public void dfs(Map<Integer,List<Integer>> map,List<Integer> res,int kill){
        if(map.containsKey(kill)){

            for(int child:map.get(kill)){
                res.add(child);
                dfs(map,res,child);
            }
        }
    }
}
