package code.salesforce;

import java.util.*;

//https://leetcode.com/problems/course-schedule-ii/solution/
//TC - O(V+E)
public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if(prerequisites==null || prerequisites.length==0){
            return new int[0];
        }

        int indegrees[] = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap();

        for(int preq[]:prerequisites){
            int src = preq[1];
            int dest = preq[0];
            List<Integer> neighbours = map.getOrDefault(src,new ArrayList());
            neighbours.add(dest);
            map.put(src,neighbours);
            indegrees[dest]++;
        }

        Queue<Integer> q = new LinkedList();
        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0){
                q.add(i);
            }
        }

        int res[] = new int[numCourses];
        int index = 0;

        while(!q.isEmpty()){

            int node = q.remove();
            res[index] = node;
            index++;
            if(map.containsKey(node)){
                for(int neighbour:map.get(node)){
                    indegrees[neighbour]--;
                    if(indegrees[neighbour]==0){
                        q.add(neighbour);
                    }
                }
            }
        }

        return index==numCourses ? res:new int[0];
    }
}
