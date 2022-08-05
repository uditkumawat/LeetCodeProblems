package code.graph;

import java.util.*;

/**
 * Time Complexity: \mathcal{O}(N+E)O(N+E). For building the graph, we spend \mathcal{O}(N)O(N) to initialize the graph, and spend \mathcal{O}(E)O(E) to add egdes since we iterate relations once. For BFS, we spend \mathcal{O}(N+E)O(N+E) since we need to visit every node and edge once in BFS in the worst case.
 *
 * Space Complexity: \mathcal{O}(N+E)O(N+E). For the graph, we spend \mathcal{O}(N+E)O(N+E) since we have \mathcal{O}(N)O(N) keys and \mathcal{O}(E)O(E) values. For BFS, we spend \mathcal{O}(N)O(N) since in the worst case, we need to add all nodes to the queue in the same time.
 *
 */
//https://leetcode.com/problems/parallel-courses/
public class ParallelCourses {

    public static void main(String args[]){

        int n = 3;
        int relations[][] = {{1,3},{2,3},{3,1}};

        ParallelCourses obj = new ParallelCourses();

        System.out.print(obj.minimumSemesters(n,relations));
    }
    public int minimumSemesters(int n, int[][] relations) {

        Map<Integer, List<Integer>> map = new HashMap();

        int indegree[] = new int[n+1];

        for(int relation[]:relations){
            int src = relation[0];
            int dest = relation[1];

            map.putIfAbsent(src,new ArrayList<>());
            map.get(src).add(dest);

            indegree[dest]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=1;i<=n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int minSteps = 0;
        int countOfNodes = 0;

        while(!q.isEmpty()){
            int size = q.size();
            minSteps++;

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

        return countOfNodes==n?minSteps:-1;
    }
}
