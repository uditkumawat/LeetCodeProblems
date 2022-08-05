package code.blind75;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/course-schedule/solution/
//TC - O(V+E)
//SC - O(V+E)
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(numCourses==0 || prerequisites==null || prerequisites.length==0){
            return true;
        }

        List<List<Integer>> adjList = new ArrayList();
        int indegrees[] = new int[numCourses];
        boolean visited[] = new boolean[numCourses];

        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList());
        }

        for(int preq[]:prerequisites){
            int src = preq[1];
            int dest = preq[0];

            adjList.get(src).add(dest);
            indegrees[dest]++;
        }

        Queue<Integer> q = new LinkedList();

        for(int i=0;i<indegrees.length;i++){
            if(indegrees[i]==0){
                q.add(i);
                visited[i] = true;
            }
        }

        int count = 0;

        while(!q.isEmpty()){

            int node = q.poll();
            count++;

            for(int neighbour:adjList.get(node)){
                if(visited[neighbour]){
                    return false;
                }
                indegrees[neighbour]--;
                if(indegrees[neighbour]==0){
                    q.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }

        return numCourses==count;
    }
}
