package code.graph;

import java.util.*;

// https://leetcode.com/problems/course-schedule/
public class CourseSchedule {

    public static void main(String args[]){

        int numCourses = 2;
        int prerequisites[][] = {{1,0},{0,1}};

        CourseSchedule obj = new CourseSchedule();

        System.out.print(obj.canFinish(numCourses,prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap();

        int indegree[] = new int[numCourses];


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

        int countOfNodes = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){

                int node = q.poll();

                countOfNodes++;

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

        return countOfNodes==numCourses;
    }
}
