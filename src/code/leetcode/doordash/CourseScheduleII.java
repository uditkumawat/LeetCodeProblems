package code.leetcode.doordash;

import java.util.*;

public class CourseScheduleII {

        public int[] findOrder(int numCourses, int[][] prerequisites) {


            int order[] = new int[numCourses];
            Map<Integer,List<Integer>> adjList = new HashMap<Integer,List<Integer>>();
            int indegree[] = new int[numCourses];

            for(int preq[]:prerequisites){
                int src = preq[1];
                int dest = preq[0];
                List<Integer> list = adjList.getOrDefault(src,new ArrayList<>());
                list.add(dest);

                adjList.put(src,list);

                indegree[dest]++;
            }

            Queue<Integer> q = new LinkedList<Integer>();

            for(int i=0;i<numCourses;i++){
                if(indegree[i]==0){
                    q.add(i);
                }
            }

            int i=0;

            while(!q.isEmpty()){
                int node = q.remove();
                order[i++] = node;

                if(adjList.containsKey(node)){
                    for(Integer neighbor : adjList.get(node)){
                        indegree[neighbor]--;

                        if(indegree[neighbor]==0){
                            q.add(neighbor);
                        }
                    }
                }
            }

            if(i==numCourses){
                return order;
            }

            return new int[0];
        }

}
