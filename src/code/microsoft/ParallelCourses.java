package code.microsoft;

import java.util.*;

//https://leetcode.com/problems/parallel-courses/

/**
 * Let EE be the length of relations. NN is the number of courses, as explained in the problem description.
 *
 * Time Complexity: \mathcal{O}(N+E)O(N+E). For building the graph, we spend \mathcal{O}(N)O(N) to initialize the graph, and spend \mathcal{O}(E)O(E) to add egdes since we iterate relations once. For BFS, we spend \mathcal{O}(N+E)O(N+E) since we need to visit every node and edge once in BFS in the worst case.
 *
 * Space Complexity: \mathcal{O}(N+E)O(N+E). For the graph, we spend \mathcal{O}(N+E)O(N+E) since we have \mathcal{O}(N)O(N) keys and \mathcal{O}(E)O(E) values. For BFS, we spend \mathcal{O}(N)O(N) since in the worst case, we need to add all nodes to the queue in the same time.
 */
public class ParallelCourses {

    public int minimumSemesters(int n, int[][] relations) {

        if(n==0){
            return 0;
        }

        Map<Integer,List<Integer>> adj = new HashMap();
        int indegrees[] = new int[n+1];
        Queue<Integer> q = new LinkedList<>();

        for(int relation[]:relations){
            int src = relation[0];
            int dest = relation[1];

            List<Integer> list = adj.getOrDefault(src,new ArrayList());
            list.add(dest);
            adj.put(src,list);

            indegrees[dest]++;
        }

        System.out.println(adj);

        for(int i=1;i<indegrees.length;i++){
            if(indegrees[i]==0){
                q.add(i);
            }
        }

        int steps = 0;
        int coursesDone = 0;

        while(!q.isEmpty()){
            int size = q.size();
            steps++;
            for(int i=0;i<size;i++){
                coursesDone++;
                int node = q.remove();
                System.out.println(node);
                if(adj.containsKey(node)){
                    for(int neigh:adj.get(node)){
                        indegrees[neigh]--;

                        if(indegrees[neigh]==0){
                            q.add(neigh);
                        }
                    }
                }
            }
        }

        return coursesDone==n?steps:-1;
    }
}
