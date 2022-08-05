package code.arcesium;

import java.util.*;

//https://leetcode.com/problems/course-schedule-ii/submissions/
public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map = new HashMap();

        int indegrees[] = new int[numCourses];

        for(int preq[]:prerequisites){
            int dest = preq[0];
            int src = preq[1];

            List<Integer> neighbours = map.getOrDefault(src,new ArrayList<>());
            neighbours.add(dest);

            map.put(src,neighbours);

            indegrees[dest]++;
        }

        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[numCourses];

        for(int i=0;i<indegrees.length;i++){
            if(indegrees[i]==0){
                q.add(i);
            }
        }

        int res[] = new int[numCourses];
        int resIndex = 0;

        int countNodes = 0;

        while(!q.isEmpty()){

            int size = q.size();

            for(int i=0;i<size;i++){

                int node = q.remove();
                res[resIndex++] = node;
                countNodes++;

                if(map.containsKey(node)){
                    for(int neighbour:map.get(node)){
                        indegrees[neighbour]--;
                        if(indegrees[neighbour]==0){
                            q.add(neighbour);
                        }
                    }
                }
            }
        }

        return countNodes==numCourses?res:new int[0];
    }
}
