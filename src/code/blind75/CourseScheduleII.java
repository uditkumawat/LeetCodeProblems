package code.blind75;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/course-schedule-ii/submissions/
//Tc - O(V+E)
//SC - O(V+E)
public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int res[] = new int[numCourses];
        int indegrees[] = new int[numCourses];

        List<List<Integer>> adjList = new ArrayList();

        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList());
        }

        for(int preq[]:prerequisites){
            int src = preq[1];
            int dest = preq[0];

            adjList.get(src).add(dest);
            indegrees[dest]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<indegrees.length;i++){
            if(indegrees[i]==0){
                q.add(i);
            }
        }

        int index = 0;

        while(!q.isEmpty()){

            int node = q.poll();
            res[index++] = node;

            for(int neighbour:adjList.get(node)){
                indegrees[neighbour]--;
                if(indegrees[neighbour]==0){
                    q.add(neighbour);
                }
            }
        }

        return index==numCourses?res:new int[0];
    }
}
