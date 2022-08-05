package code.graph;

import java.util.*;

//https://leetcode.com/problems/course-schedule-ii/
public class CourseScheduleII {

    public static void main(String args[]){

        int numCourses = 4;
        int prerequisites[][] = {{1,0},{2,0},{3,1},{3,2}};

        CourseScheduleII obj = new CourseScheduleII();

        int res[] = obj.findOrder(numCourses,prerequisites);

        for(int num:res){
            System.out.print(num+" ");
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap();

        int indegree[] = new int[numCourses];
        int res[] = new int[numCourses];

        for(int prerequisite[]:prerequisites){
            int dest = prerequisite[0];
            int src = prerequisite[1];

            map.putIfAbsent(src,new ArrayList<>());
            map.get(src).add(dest);

            indegree[dest]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int resIndex = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){

                int node = q.poll();
                res[resIndex++] = node;

                if(map.containsKey(node)){

                    for(int neighbour:map.get(node)){
                        indegree[neighbour]--;
                        if(indegree[neighbour]==0){
                            q.add(neighbour);
                        }
                    }
                }
            }
        }

        return res;
    }
}
