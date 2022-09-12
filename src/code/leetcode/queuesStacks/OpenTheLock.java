package code.leetcode.queuesStacks;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/open-the-lock/submissions/
//https://www.youtube.com/watch?v=vtxETRvR9JY
public class OpenTheLock {

    public int openLock(String[] deadends, String target) {

        if(target==null || target.length()==0){
            return -1;
        }

        Set<String> visited = new HashSet();

        for(String deadend:deadends){
            visited.add(deadend);
        }

        Queue<String> q = new LinkedList();
        q.add("0000");

        int level = 0;

        while(!q.isEmpty()){

            int size = q.size();

            while(size-->0){

                String currStr = q.remove();

                if(visited.contains(currStr)){
                    continue;
                }
                if(currStr.equals(target)){
                    return level;
                }

                for(String nextString:getNextStates(currStr)){
                    if(!visited.contains(nextString)){
                        q.add(nextString);
                    }
                }
                visited.add(currStr);
            }
            level++;
        }

        return -1;
    }

    public Set<String> getNextStates(String str){

        Set<String> set = new HashSet();
        char c[] = str.toCharArray();

        for(int i=0;i<c.length;i++){

            //clockwise
            char temp = c[i];

            c[i] = temp=='9'?'0':(char)(temp+1);
            set.add(new String(c));

            //anticlockwise
            c[i] = temp=='0'?'9':(char)(temp-1);
            set.add(new String(c));

            c[i] = temp;
        }

        //System.out.println(set);

        return set;
    }
}
