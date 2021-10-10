package code.top100;

import java.util.*;

/**
 * Time Complexity: O(V + E)O(V+E) where VV represents the number of vertices and EE represents the number of edges. We pop each node exactly once from the zero in-degree queue and that gives us VV. Also, for each vertex, we iterate over its adjacency list and in totality, we iterate over all the edges in the graph which gives us EE. Hence, O(V + E)O(V+E)
 *
 * Space Complexity: O(V + E)O(V+E). We use an intermediate queue data structure to keep all the nodes with 0 in-degree. In the worst case, there won't be any prerequisite relationship and the queue will contain all the vertices initially since all of them will have 0 in-degree. That gives us O(V)O(V). Additionally, we also use the adjacency list to represent our graph initially. The space occupied is defined by the number of edges because for each node as the key, we have all its adjacent nodes in the form of a list as the value. Hence, O(E)O(E). So, the overall space complexity is O(V + E)O(V+E).
 */
public class CourseScheduleII {

    public static void main(String args[]){

        int courses[][] = {{1,0}};
        int numberOfCourses = 2;
        int order[] = generate(courses,numberOfCourses);

        for(int n:order){
            System.out.print(n+" ");
        }
    }

    public static int[] generate(int courses[][],int numberOfCourses){
        if(courses==null || courses.length==0){
            return new int[0];
        }

        int indegree[] = new int[numberOfCourses];

        Map<Integer,List<Integer>> adjList = new HashMap<>();

        for(int schedule[]:courses){
            int source = schedule[1];
            int destination = schedule[0];
            if(adjList.containsKey(source)){
                List<Integer> otherVertices = adjList.get(source);
                otherVertices.add(destination);
                adjList.put(source,otherVertices);
            }
            else{
                List<Integer> otherVertices = new ArrayList<>();
                otherVertices.add(destination);
                adjList.put(source,otherVertices);
            }
            indegree[destination]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int order[] = new int[numberOfCourses];
        int i=0;
        while(!q.isEmpty()){

            int vertice = q.poll();
            order[i++] = vertice;

            if(adjList.containsKey(vertice)){
                List<Integer> list = adjList.get(vertice);

                for(int v:list){
                    indegree[v]--;

                    if(indegree[v]==0){
                        q.add(v);
                    }
                }
            }
        }

        if(i==numberOfCourses){
            return order;
        }

        return new int[0];
    }
}
