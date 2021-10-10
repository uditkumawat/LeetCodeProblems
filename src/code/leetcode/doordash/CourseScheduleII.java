package code.leetcode.doordash;

import java.util.*;

//TC - O(V+e) topolical sort
//SC - O(V)   stack

/**
 * Time Complexity: O(V + E)O(V+E) where VV represents the number of vertices and EE represents the number of edges. We pop each node exactly once from the zero in-degree queue and that gives us VV. Also, for each vertex, we iterate over its adjacency list and in totality, we iterate over all the edges in the graph which gives us EE. Hence, O(V + E)O(V+E)
 *
 * Space Complexity: O(V + E)O(V+E). We use an intermediate queue data structure to keep all the nodes with 0 in-degree. In the worst case, there won't be any prerequisite relationship and the queue will contain all the vertices initially since all of them will have 0 in-degree. That gives us O(V)O(V). Additionally, we also use the adjacency list to represent our graph initially. The space occupied is defined by the number of edges because for each node as the key, we have all its adjacent nodes in the form of a list as the value. Hence, O(E)O(E). So, the overall space complexity is O(V + E)O(V+E).
 */
public class CourseScheduleII {

    public static void main(String args[]){
        int numCourses=4;
        int pre[][] = {{1,0},{2,0},{3,1},{3,2}};
        int output[] = getOrder(numCourses,pre);
        for(int i:output){
            System.out.print(i+" ");
        }
    }

    //kahn's algorithm
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

        //topological sort
        public static int[] getOrder(int numCourses, int[][] prerequisites){

            int output[] = new int[numCourses];
            Map<Integer,List<Integer>> adjList = new HashMap<>();
            for(int schedule[]:prerequisites){
                int source = schedule[1];
                int destination = schedule[0];

                List<Integer> neighbours = adjList.getOrDefault(source,new ArrayList<>());
                neighbours.add(destination);

                adjList.put(source,neighbours);
            }
            Stack<Integer> stack = new Stack<>();
            int visited[] = new int[numCourses];
            for(int i=0;i<numCourses;i++){
                if(visited[i]==0){
                    if(dfs(adjList,i,stack,visited)){
                        System.out.println("Cycle exists");
                        return new int[0];
                    }
                }
            }

            int index=0;
            while(!stack.isEmpty()){
                output[index++] = stack.pop();
            }

            return output;
        }

        public static boolean dfs(Map<Integer,List<Integer>> adjList,int node,Stack<Integer> stack,int visited[]){

            if(visited[node]==1){
                return true;
            }

            visited[node] = 1;

            if(adjList.containsKey(node)) {
                for (int neighbour : adjList.get(node)) {
                    if (visited[neighbour]!=2) {
                        if(dfs(adjList, neighbour, stack, visited)){
                            return true;
                        }
                    }
                }
            }

            visited[node] = 2;
            stack.push(node);
            return false;
        }

}
