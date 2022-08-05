package code.bloomberg;

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

            if(ppid.get(i)!=0){
                List<Integer> childProcesses = map.getOrDefault(ppid.get(i),new ArrayList<>());
                childProcesses.add(pid.get(i));

                map.put(ppid.get(i),childProcesses);
            }
        }

        List<Integer> res = new ArrayList<>();
        res.add(kill);
        killChildren(map,kill,res);
        return res;
    }


    public void killChildren(Map<Integer,List<Integer>> map,int kill,List<Integer> res){

        if(map.containsKey(kill)){

            for(int childProcess:map.get(kill)){
                res.add(childProcess);
                killChildren(map,childProcess,res);
            }
        }
    }
}
